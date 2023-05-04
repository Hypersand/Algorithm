import java.util.*;

class Solution {
    
    public boolean[] visited;
    public int maxCount = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
    
        find(dungeons,k,0);
        
        return maxCount;
    }
    
    public void find(int[][] dungeons, int k, int cnt) {
        
        
        for (int i = 0; i<dungeons.length; i++) {
            if(!visited[i]&&dungeons[i][0]<=k) {
                visited[i] = true;
                k -= dungeons[i][1];
                find(dungeons,k,cnt+1);
                k += dungeons[i][1];
                visited[i] = false;
            }
        }
        
        maxCount = Math.max(maxCount,cnt);
    } 
}