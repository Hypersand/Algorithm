import java.util.*;
class Solution {
    //각 노드에서 최단 거리 구해야 함.
    private static List<Integer>[] lists;
    private static int[] groups;
    private static int[] dists;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        lists = new ArrayList[n+1];
        groups = new int[n+1];
        dists = new int[n+1];
        for (int i = 1; i<=n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i<roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            lists[u].add(v);
            lists[v].add(u);
        }
        
        bfs(destination, 1);
        
        int[] results = new int[sources.length];
        for (int i = 0; i<sources.length; i++) {
            if (groups[sources[i]] != groups[destination]) {
                results[i] = -1;
            } else {
                results[i] = dists[sources[i]];
            }
        }
        
        return results;
    }
    
    private static void bfs(int start, int groupNum) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        groups[start] = groupNum;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : lists[cur]) {
                if (groups[next] == 0) {
                    groups[next] = groupNum;
                    dists[next] = dists[cur] + 1;
                    queue.add(next);
                }
            }
        }
    }
    
}