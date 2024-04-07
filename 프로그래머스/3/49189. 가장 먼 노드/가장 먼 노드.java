import java.util.*;

class Solution {
    private static List<Integer>[] lists;
    private static int[] dists;
    private static boolean[] visited;
    public int solution(int n, int[][] edge) {
        lists = new ArrayList[n + 1];
        dists = new int[n+1];
        visited = new boolean[n + 1];
        for (int i = 1; i<=n; i++) {
            lists[i] = new ArrayList<>();
        }
        
        for (int i = 0; i<edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            lists[start].add(end);
            lists[end].add(start);
        }
        
        bfs();
        Arrays.sort(dists);
        int max = dists[n];
        int cnt = 0;
        for (int i = n; i>=0; i--) {
            if (max == dists[i]) {
                cnt++;
                continue;
            }
            
            if (max < dists[i]) {
                cnt = 1;
                max = dists[i];
            }
        }
        
        return cnt;
    }
    
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : lists[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dists[next] = dists[cur] + 1;
                    queue.add(next);
                }
            }
        }
    }
}