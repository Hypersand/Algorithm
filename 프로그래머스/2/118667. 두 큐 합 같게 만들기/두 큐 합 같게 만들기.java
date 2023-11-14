import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        long q1Sum = 0;
        long q2Sum = 0;
        for (int i = 0; i<queue1.length; i++) {
            q1.add((long)queue1[i]);
            q2.add((long)queue2[i]);
            q1Sum += queue1[i];
            q2Sum += queue2[i];
        }
        
        long size = (q1Sum + q2Sum) / 2;
        int cnt = 0;
        
        while (cnt <= 3 * queue1.length) {
            if (q1Sum < size) {
                long tmp = q2.poll();
                q1.add(tmp);
                q1Sum += tmp;
                q2Sum -= tmp;
                cnt++;
            } else if (size > q2Sum) {
                long tmp = q1.poll();
                q2.add(tmp);
                q1Sum -= tmp;
                q2Sum += tmp;
                cnt++;
                
            } else {
                break;
            }
        }
        
        if (cnt > 3*queue1.length) {
            return -1;
        } else {
            return cnt;
        }
    }
}