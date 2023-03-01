import java.util.*;

class Solution {
    
    public boolean[] visited;
    public List<Integer>[] list;
    
    public int solution(int n, int[][] computers) {
        list = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i<n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i<computers.length; i++) {
            for (int j = 0; j<computers[i].length; j++) {
                if(i==j) continue;
                
                if(computers[i][j]==1) {
                    list[i].add(j);    
                }
            }
        }
        
        int count = 0;

        for (int i = 0; i<n; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }
        
        return count;
    }
    
    public void dfs(int a) {
        
        visited[a] = true;
        for (Integer num : list[a]) {
            if(!visited[num]) {
                dfs(num);
            }
        }  
        
    }
    
}