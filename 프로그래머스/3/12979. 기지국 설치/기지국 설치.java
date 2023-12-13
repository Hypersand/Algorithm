import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int pos = 1;
        int ans = 0;
        for (int i = 0; i<stations.length; i++) {
            int start = stations[i] - w;
            int end = stations[i] + w;
            if (pos < start) {
                ans += search(pos, start-1, w);
            }
            pos = end + 1;
        }
        //마지막 전파범위가 커버하지 못하는 부분이 있다면
        if (stations[stations.length - 1] + w < n) {
            ans += search(stations[stations.length - 1] + w + 1, n, w);
        }

        return ans;
    }
    private static int search(int start, int end, int w) {
        int cnt = (end - start + 1) / (2 * w + 1);
        if ((end - start + 1) % ((2 * w) + 1) > 0) {
            cnt++;
        }
        return cnt;
    }
}