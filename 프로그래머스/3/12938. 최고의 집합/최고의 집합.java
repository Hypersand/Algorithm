import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        
        int key = s / n;
        int tmp = s % n;
        int[] answer = new int[n];
        Arrays.fill(answer, key);
        for (int i = n - 1; i>=0; i--) {
            if (tmp > 0) {
                answer[i]++;
                tmp--;
            }
        }
        
        return answer;
    }
}