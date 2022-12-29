import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> queue = new PriorityQueue<>(); 
        int count = 0;
        
        for(int i = 0; i<scoville.length; i++) {
            queue.add((long)scoville[i]);
        }
        
        while(!queue.isEmpty()) {
            
            if(queue.peek()>=K) {
                break;
            }
            if(queue.size()<=1) {
                return -1;
            }
            long tmp = queue.poll() + (queue.poll()*2);
            queue.add(tmp);
            count++;
        }
        
        return count;
    }
}