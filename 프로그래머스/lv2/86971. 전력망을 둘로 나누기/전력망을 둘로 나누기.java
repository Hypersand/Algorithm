import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List[] lists = new List[n+1];
        for (int i = 0; i<lists.length; i++) {
            lists[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i<wires.length; i++) {
            lists[wires[i][0]].add(wires[i][1]);
            lists[wires[i][1]].add(wires[i][0]);
        }
        
        int min = 9999999;
        
        for (int i = 0; i<wires.length; i++) {
            lists[wires[i][0]].remove(Integer.valueOf(wires[i][1]));
            lists[wires[i][1]].remove(Integer.valueOf(wires[i][0]));
            int result = find(lists);
            int tmp = n - result;
            min = Math.min(min, Math.abs(result - tmp));
            lists[wires[i][0]].add(wires[i][1]);
            lists[wires[i][1]].add(wires[i][0]);
        }       
        
        return min;
    }
    
    public int find(List[] lists) {
        boolean[] visited = new boolean[lists.length];
        int result = 0;
        
        for (int i = 1; i<lists.length; i++) {
            if(!lists[i].isEmpty()) {
                result = bfs(visited, lists, i);
                break;
            }
        }
        
        return result;
    }
    
    public int bfs(boolean[] visited, List[] lists, int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        int cnt = 1;
        visited[idx] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i<lists[node].size(); i++) {
                if(!visited[(int)lists[node].get(i)]) {
                    cnt++;
                    queue.add((int)lists[node].get(i));
                    visited[(int)lists[node].get(i)] = true;
                }
            }
        }
        return cnt;
    }
}