import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }
        
        for (int i = 0; i < m; i++) {
            if (dp[0][i] == -1) break;
            dp[0][i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            if (dp[i][0] == -1) break;
            dp[i][0] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] == -1) continue;
                int a = dp[i - 1][j];
                int b = dp[i][j - 1];
                if (a == -1) a = 0;
                if (b == -1) b = 0;
                dp[i][j] = (a + b) % 1000000007;
            }
        }
        
        return dp[n - 1][m - 1];
        
    }
}