import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        int point = -1;
        int cnt = 0;
        for (int i = 0; i<targets.length; i++) {
            if (point >= targets[i][0]) continue;
            
            cnt++;
            point = targets[i][1] - 1;
        }
        
        return cnt;
    }
}