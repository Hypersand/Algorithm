class Solution {
    public int solution(int n) {
        boolean [] dp = new boolean[n+1];
        
        if(n==1) return 0;
        
        for(int i = 2; i<Math.sqrt(n); i++) {
            for(int j = i*2; j<=n; j+=i) {
                if(j%i==0&&!dp[j]) {
                    dp[j] = true;
                }
            }
        }
        
        int count = 0;
        for(int i = 2; i<=n; i++) {
            if(!dp[i]) {
                count++;
            }
        }
        
        return count;
    }
}