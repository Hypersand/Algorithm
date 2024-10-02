import java.util.*;

class Solution {
    private static boolean[] visited;
    private static List<Integer>[] lists;
    public int solution(int n, int[][] wires) {
        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            lists[a].add(b);
            lists[b].add(a);
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < lists[i].size(); j++) {
                List<Integer> list = new ArrayList<>();
                visited = new boolean[n + 1];
                visited[lists[i].get(j)] = true;
                list.add(find(i));
                visited[lists[i].get(j)] = false;
                for (int t = 1; t <= n; t++) {
                    if (!visited[t]) {
                        list.add(find(t));
                    }
                }
                
                if (list.size() == 2) {
                    answer = Math.min(answer, Math.abs(list.get(0) - list.get(1)));
                }
                
            }
        }
        
        return answer;
    }
    
    private static int find(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int cnt = 1;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : lists[cur]) {
                if (visited[next]) continue;
                queue.add(next);
                cnt++;
                visited[next] = true;
            }
        }
        
        return cnt;
    }
}