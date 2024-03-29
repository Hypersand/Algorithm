import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];
        dp1[0] = sequence[0];
        dp2[0] = sequence[0] * (-1);
        long max = Math.max(dp1[0], dp2[0]);
        int[] multiple1 = {1, -1};
        int[] multiple2 = {-1, 1};
        for (int i = 1; i<sequence.length; i++) {
            //홀수 번째 수
            long num1 = dp1[i-1] + sequence[i] * multiple1[i%2];
            long num2 = sequence[i] * multiple1[i%2];
            long num3 = dp2[i-1] + sequence[i] * multiple2[i%2];
            long num4 = sequence[i] * multiple2[i%2];
            dp1[i] = Math.max(num1, num2);
            dp2[i] = Math.max(num3, num4);
            max = Math.max(max, Math.max(dp1[i], dp2[i]));
        }
        return max;
    }
}