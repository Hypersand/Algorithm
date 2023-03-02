import java.util.*;

class Solution {
    
    public boolean[] visited;
    public int maxCount = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
    
        find(dungeons,k,0);
        
        return maxCount;
    }
    
    public void find(int[][] dungeons, int n, int cnt) {
        if(n<=0) {
            int count = 0;
            for (int i = 0; i<dungeons.length; i++) {
                if(visited[i]) {
                    count++;
                }
            }
            
            if(n==0) {
                maxCount = Math.max(maxCount,count);
            }
            else {
                maxCount = Math.max(maxCount,count-1);    
            }
    
            return;
        }
        
        for (int i = 0; i<dungeons.length; i++) {
            if(!visited[i]&&dungeons[i][0]<=n) {
                visited[i] = true;
                n -= dungeons[i][1];
                System.out.println(n);
                find(dungeons,n,cnt+1);
                n += dungeons[i][1];
                visited[i] = false;
            }
        }
        
        maxCount = Math.max(maxCount,cnt);
    } 
}