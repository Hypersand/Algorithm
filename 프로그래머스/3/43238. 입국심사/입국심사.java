import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = times[0];
        long end = n * (long)times[times.length - 1];
        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for (int i = 0; i<times.length; i++) {
                cnt += mid / times[i];
            }
            
            if (cnt >= n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return start;
    }
}