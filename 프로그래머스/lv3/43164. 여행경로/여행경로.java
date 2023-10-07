import java.util.*;

class Solution {
    public static boolean[] visited;
    public static List<String> results = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(results);
        return results.get(0).split(" ");
    }
    
    public void dfs(int cnt, String start, String result, String[][] tickets) {
        if (cnt == tickets.length) {
            results.add(result);
            return;
        }
        
        for (int i = 0; i<tickets.length; i++) {
            if(tickets[i][0].equals(start)) {
                if(!visited[i]) {
                    visited[i] = true;
                    dfs(cnt + 1, tickets[i][1], result + " " + tickets[i][1], tickets);
                    visited[i] = false;
                }   
            }
        }
    }
}