import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (route1, route2) -> route1[1] - route2[1]);
        
        int cnt = 1;
        int end = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if (end < routes[i][0]) {
                cnt++;
                end = routes[i][1];
            }
            
        }
        
        return cnt;
    }
}