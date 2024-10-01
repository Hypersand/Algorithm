import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            queue.add(new Node(i, priorities[i]));
        }
        
        int key = pq.poll();
        int order = 1;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if (key == node.value) {
                if (node.idx == location) return order;
                key = pq.poll();
                order++;
                continue;
            }
            
            queue.add(node);
        }
        
        return 1;
    }
    
    private static class Node {
        private int idx;
        private int value;
        
        private Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}