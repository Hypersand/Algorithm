import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int [] dx = {1,1};
        int [] dy = {0,1};
        
        int [][] dp = new int[triangle.length][triangle[triangle.length-1].length];
        dp[0][0] = triangle[0][0];
        int max = 0;
        for(int i = 0; i<triangle.length-1; i++) {
            for(int j = 0; j<triangle[i].length; j++) {
                for(int k = 0; k<2; k++) {
                    int nx = dx[k] + i;
                    int ny = dy[k] + j;
                    dp[nx][ny] = Math.max(dp[nx][ny],dp[i][j]+triangle[nx][ny]);
                    max = Math.max(dp[nx][ny],max);
                }    
            }
        }
        
        return max;
    }
}