import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int cnt = 0;
        int end = 1;
        for (int i = 0; i<stations.length; i++) {
            int now_start = stations[i] - w;
            int now_end = stations[i] + w;
            if (now_start < 1) now_start = 1;
            if (now_end > n) now_end = n;
            if (end < now_start) {
                cnt += (now_start - end) / (2 * w + 1);
                if ((now_start - end) % (2 * w + 1) != 0) cnt++;
            }
            end = now_end + 1;
        }
        
        if (end <= n) {
            cnt += (n - end + 1) / (2 * w + 1);
            if ((n - end + 1) % (2 * w + 1) != 0) cnt++;
        }

        return cnt;
    }
}