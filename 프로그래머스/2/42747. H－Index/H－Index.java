import java.util.*;

class Solution {    
    public int solution(int[] citations) {
        int max = 0;
        for (int i = 0; i <= 10000; i++) {
            int cnt = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= i) cnt++;
            }
            
            if (cnt >= i) max = i;
        }
        
        return max;
    }
}