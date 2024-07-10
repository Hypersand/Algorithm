import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[m + 1][n + 1];
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i<puddles.length; i++) {
            arr[puddles[i][0]][puddles[i][1]] = 1;
        }
        
        for (int i = 1; i<=m; i++) {
            if (arr[i][1] == 1) break;
            dp[i][1] = 1;
        }
        
        for (int i = 1; i<=n; i++) {
            if (arr[1][i] == 1) break;
            dp[1][i] = 1;
        }
        
        for (int i = 1; i<=m; i++) {
            for (int j = 1; j<=n; j++) {
                if (arr[i][j] == 1) continue;
                if (i == 1 || j == 1) continue;
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }
        
        return dp[m][n];
    }
}