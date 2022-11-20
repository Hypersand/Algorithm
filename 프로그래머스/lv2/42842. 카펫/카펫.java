
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int [] answer = new int[2];
        int sum = brown + yellow;
        int j = 0;
        int n = (int)(Math.sqrt(sum));
        
        for (int i = n; i>=1; i--) {
            if(sum % i == 0 && (i-2)*(sum/i-2) == yellow) {
                j = sum / i;
                answer[0] = j;
                answer[1] = i;
                break;
            }
        }
        
        return answer;
    }
}