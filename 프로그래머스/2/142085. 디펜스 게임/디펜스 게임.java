import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        if (k >= enemy.length) {
            return enemy.length;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i<k; i++) {
            pq.add(enemy[i]);
        }
        int stage = k;
        for (int i = k; i<enemy.length; i++) {
            if (pq.peek() < enemy[i]) {
                n -= pq.poll();
                pq.add(enemy[i]);
            } else {
                n -= enemy[i];
            }
            if (n < 0) break;
            stage++;
        }
        
        return stage;
    }
}