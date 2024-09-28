import java.util.*;

class Solution {
    private static List<Integer>[] lists;
    private static List<Integer>[] reverseLists;
    private static boolean[] visited;
    private static int N;
    public int solution(int n, int[][] results) {
        lists = new ArrayList[n + 1];
        reverseLists = new ArrayList[n + 1];
        N = n;
        
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
            reverseLists[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < results.length; i++) {
            int a = results[i][0];
            int b = results[i][1];
            lists[a].add(b);
            reverseLists[b].add(a);
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (find(i)) answer++;
        }
        
        return answer;
    }
    
    private static boolean find(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        visited = new boolean[N + 1];
        visited[idx] = true;
        
        int cnt = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : lists[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    cnt++;
                }
            }
        }
        
        queue.add(idx);
        visited = new boolean[N + 1];
        visited[idx] = true;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : reverseLists[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    cnt++;
                }
            }
        }
        
        if (cnt == N - 1) return true;
        
        return false;
    }
}