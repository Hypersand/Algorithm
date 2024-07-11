import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i<works.length; i++) {
            pq.add((long)works[i]);
        }
        
        while (!pq.isEmpty() && n != 0) {
            long num = pq.poll();
            if (num != 0) {
                pq.add(num - 1);
            } 
            n--;
        }
        
        long sum = 0;
        while (!pq.isEmpty()) {
            sum += (long)Math.pow(pq.poll(), 2);
        }
        
        return sum;
    }
}