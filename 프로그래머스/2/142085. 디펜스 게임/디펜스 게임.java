import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if (k > enemy.length) return enemy.length;
        for (int i = 0; i<k; i++) {
            pq.add(enemy[i]);
        }    
        int answer = k;
        for (int i = k; i<enemy.length; i++) {
            //우선순위큐의 가장 작은 수보다 클 경우
            if (!pq.isEmpty() && pq.peek() < enemy[i]) {
                int tmp = pq.poll();
                pq.add(enemy[i]);
                n -= tmp;
            } else {
                n -= enemy[i];
            }
            
            if (n < 0) {
                break;
            } else {
                answer++;
            }
        }
        return answer;
    }
}