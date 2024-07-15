import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int[][] dp = new int[money.length + 1][n + 1];
        // i : 거스름돈 종류, j : 원
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j == 0) dp[i][j] = 1;
                if (j - money[i - 1] < 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                    continue;
                } else if (j - money[i - 1] == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j], (dp[i - 1][j] + dp[i][j - money[i - 1]]) % 1000000007);
                }
                
            }
        }
        
        return dp[money.length][n];
        
    }
}