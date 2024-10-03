import java.util.*;

class Solution {
    private static int[] parents;
    public int solution(int n, int[][] costs) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];
            pq.add(new Edge(a, b, cost));
        }   
        
        int answer = 0;
        
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (find(edge.a) != find(edge.b)) {
                union(edge.a, edge.b);
                answer += edge.cost;
            }
        }
        
        return answer;
    }
    
    private static void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        
        if (pA <= pB) {
            parents[pB] = pA;
        } else {
            parents[pA] = pB;
        }
        
    }
    
    private static int find(int node) {
        if (parents[node] == node) return parents[node];
        
        return parents[node] = find(parents[node]);
    }
    
    private static class Edge implements Comparable<Edge> {
        private int a;
        private int b;
        private int cost;
        
        private Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
        
        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }
}