import java.util.*;
class Solution {
    public int solution(int storey) {
        int cnt = 0;
        while (storey > 0) {
            int num = storey % 10;
            if (num < 5) {
                storey /= 10;
                cnt += num;
                continue;
            }
            if (num > 5) {
                storey /= 10;
                storey++;
                cnt += 10 - num;
                continue;
            }
            
            //num = 5라면
            storey /= 10;
            if (storey % 10 >= 5) {
                storey++;
                cnt += 5;
            } else {
                cnt += 5;
            }
        }
        return cnt;
    }
}