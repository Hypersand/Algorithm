import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        boolean[] isUsed = new boolean[n+1];
        int[] answer = new int[n];
        int ansIdx = 0;
        while (n > 1) {
            long cnt = 1;
            for (int i = 1; i<=n-1; i++) {
                cnt *= i;
            }
            
            long numIdx = 1;
            if (k % cnt > 0) {
                numIdx = k / cnt + 1;
            } else {
                numIdx = k / cnt;
            }
            
            int idx = 1;
            for (int i = 1; i< isUsed.length; i++) {
                if (!isUsed[i]) {
                    if (idx == numIdx) {
                        isUsed[i] = true;
                        answer[ansIdx++] = i;
                        //k랑 n도 줄어야됨
                        k -= cnt * (numIdx - 1);
                        n--;
                        break;
                    }
                    idx++;
                }
            }
        }
        
        for (int i = 1; i< isUsed.length; i++) {
            if (!isUsed[i]) {
                answer[ansIdx++] = i;
            }
        }
        
        return answer;
    }
}