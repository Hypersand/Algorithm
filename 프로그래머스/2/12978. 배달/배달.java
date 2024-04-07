import java.util.*;

class Solution {
    private static List<Node>[] lists;
    private static int[] dists;
    private static final int INF = 1000000000;
    public int solution(int N, int[][] road, int K) {
        dists = new int[N+1];
        Arrays.fill(dists, INF);
        lists = new ArrayList[N+1];
        for (int i = 1; i<=N; i++) {
            lists[i] = new ArrayList<>();
        }
        
        for (int i = 0; i<road.length; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int dist = road[i][2];
            lists[start].add(new Node(end, dist));
            lists[end].add(new Node(start, dist));
        }
        
        dijkstra();
        int answer = 0;
        for (int i = 1; i<=N; i++) {
            if (dists[i] <= K) answer++;
        }


        return answer;
    }
    
    private static void dijkstra() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        dists[1] = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (Node node : lists[num]) {
                if (dists[node.x] > dists[num] + node.dist) {
                    dists[node.x] = dists[num] + node.dist;
                    queue.add(node.x);
                }
            }
        }
    }
    
    private static class Node {
        private int x;
        private int dist;
        
        public Node(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }
    }
}