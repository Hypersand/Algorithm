import java.util.*;

class Solution {
    private static List<Node>[] lists;
    private static Set<Integer> gateSet = new HashSet<>();
    private static Set<Integer> summitSet = new HashSet<>();
    private static int[] dists;
    private static PriorityQueue<Node> pq = new PriorityQueue<>();
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        lists = new ArrayList[n+1];
        dists = new int[n+1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        for (int i = 1; i<=n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i<gates.length; i++) {
            gateSet.add(gates[i]);
        }
        for (int i = 0; i<summits.length; i++) {
            summitSet.add(summits[i]);
        }

        for (int i = 0; i<paths.length; i++) {
            if (gateSet.contains(paths[i][0])) {
                lists[paths[i][0]].add(new Node(paths[i][1], paths[i][2])); 
            } else if (gateSet.contains(paths[i][1])) {
                lists[paths[i][1]].add(new Node(paths[i][0], paths[i][2]));
            } else if (summitSet.contains(paths[i][0])) {
                lists[paths[i][1]].add(new Node(paths[i][0], paths[i][2]));
            } else if (summitSet.contains(paths[i][1])) {
                lists[paths[i][0]].add(new Node(paths[i][1], paths[i][2])); 
            }
            else {
                lists[paths[i][0]].add(new Node(paths[i][1], paths[i][2])); 
                lists[paths[i][1]].add(new Node(paths[i][0], paths[i][2]));
            }
        }
        
        for (int i = 0; i<gates.length; i++) {
            pq.add(new Node(gates[i], 0));
            dists[gates[i]] = 0;
        }
        
        find();
        
        int min = Integer.MAX_VALUE;
        int node = 0;
        for (int i = 0; i<summits.length; i++) {
            if(dists[summits[i]] < min) {
                min = dists[summits[i]];
                node = summits[i];
            } else if (dists[summits[i]] == min && summits[i] < node) {
                node = summits[i];
            }
        }
        
        return new int[]{node, min};
    }
    
    public static void find() {
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if(summitSet.contains(node.idx)) continue;
            if(dists[node.idx] < node.intensity) continue;
            for (Node next : lists[node.idx]) {
                if(dists[next.idx] > Math.max(dists[node.idx], next.intensity)) {
                    dists[next.idx] = Math.max(dists[node.idx], next.intensity);
                    pq.add(new Node(next.idx, dists[next.idx]));
                }
            }
        }
        
    }
    
    
    public static class Node implements Comparable<Node> {
        int idx;
        int intensity;
        public Node (int idx, int intensity) {
            this.idx = idx;
            this.intensity = intensity;
        }
        
        @Override
        public int compareTo(Node node) {
            return this.intensity - node.intensity;
        }
    }
}
