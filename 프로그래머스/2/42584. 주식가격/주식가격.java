import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int idx = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < prices.length; i++) {
            while(!pq.isEmpty() && pq.peek().price > prices[i]) {
                Node node = pq.poll();
                answer[node.idx] = i - node.idx;
            }
            pq.add(new Node(i, prices[i]));
        }
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            answer[node.idx] = prices.length - node.idx - 1;
        }
        
        return answer;
    }
    
    private static class Node implements Comparable<Node> {
        private int idx;
        private int price;
        
        public Node(int idx, int price) {
            this.idx = idx;
            this.price = price;
        }
        
        public int compareTo(Node node) {
            return node.price - this.price;
        }
    }
}