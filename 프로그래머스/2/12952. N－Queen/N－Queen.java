import java.util.*;
class Solution {
    private static int N;
    private static int[] dp;
    private static int answer = 0;
    public int solution(int n) {
        N = n;
        dp = new int[N];
        comb(0);
        return answer;
    }
    private static void comb(int row) {
        if (row == N) {
            answer++;
            return;
        }
        
        //열 이동
        for (int i = 0; i<N; i++) {
            dp[row] = i;
            boolean isTrue = true;
            for (int j = 0; j<row; j++) {
                //같은 열에 배치된게 있는지 확인
                if (dp[j] == dp[row]) {
                    isTrue = false;
                    break;
                }
                //같은 대각선상에 배치된게 있는지 확인
                //행증가량 == 열증가량 -> 같은 대각선
                if (Math.abs(row - j) == Math.abs(dp[row]-dp[j])) {
                    isTrue = false;
                    break;
                }
            }
            
            if (isTrue) {
                comb(row + 1);
            }   
        }
        
    }

}