import java.util.*;

class Solution {
    private static int[] dp = new int[1000001];
    private static final int INF = 10000000;
    public int solution(int x, int y, int n) {
        Arrays.fill(dp, INF);
        find(x, y, n);
        
        if (dp[y] == INF) return -1;
        return dp[y];
    }
    
    private static void find(int x, int y, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        dp[x] = 0;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur + n <= 1000000) {
                if (dp[cur + n] > dp[cur] + 1) {
                    queue.add(cur + n);
                    dp[cur + n] = dp[cur] + 1;
                }
            }
            
            if (cur * 2 <= 1000000) {
                if (dp[cur * 2] > dp[cur] + 1) {
                    queue.add(cur * 2);
                    dp[cur * 2] = dp[cur] + 1;
                }
            }
            
            if (cur * 3 <= 1000000) {
                if (dp[cur * 3] > dp[cur] + 1) {
                    queue.add(cur * 3);
                    dp[cur * 3] = dp[cur] + 1;
                }
            }
        }
        
    }
}