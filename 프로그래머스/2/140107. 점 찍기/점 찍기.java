import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long max = d / k;
        //a값에 따른 최대의 b값 구하기
        for (long i = 0; i <= max; i++) {
            long start = 0;
            long end = max;
            while (start <= end) {
                //임시 b값
                long mid = (start + end) / 2;
                double dis = Math.sqrt((i * k) * (i * k) + (mid * k) * (mid * k));
                //구한 거리가 d보다 커지는 첫번째 b값 구하기 (upper bound)
                if (dis > d) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }   
            }
            answer += (start);
        }
        return answer;
    }
}