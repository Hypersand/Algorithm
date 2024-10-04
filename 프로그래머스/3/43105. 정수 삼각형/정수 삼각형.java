import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        if (triangle.length == 1) return triangle[0][0];
        
        int[][] dp = new int[triangle.length + 1][triangle.length + 1];
        dp[1][1] = triangle[0][0];
        
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i - 1][j - 1];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < dp[0].length; i++) {
            answer = Math.max(answer, dp[dp.length - 1][i]);
        }
        
        return answer;
    }
}