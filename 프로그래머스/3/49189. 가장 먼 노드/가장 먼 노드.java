import java.util.*;

class Solution {
    private static List<Integer>[] lists;
    private static int[] dists;
    public int solution(int n, int[][] edge) {
        lists = new ArrayList[n + 1];
        dists = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            lists[a].add(b);
            lists[b].add(a);
        }
        
        find();
        
        int cnt = 1;
        int maxDist = 0;
        for (int i = 2; i <= n; i++) {
            if (dists[i] > maxDist) {
                maxDist = dists[i];
                cnt = 1;
                continue;
            }
            
            if (dists[i] == maxDist) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    private static void find() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dists[1] = 1;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : lists[cur]) {
                if (dists[next] != 0) continue;
                dists[next] = dists[cur] + 1;
                queue.add(next);
            }
        }
        
    }
}