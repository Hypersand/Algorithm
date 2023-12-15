import java.util.*;
class Solution {
    public int solution(int storey) {
        int cnt = 0;
        while (storey > 0) {
            int num = storey % 10;
            storey /= 10;
            if (num < 5) {
                cnt += num;
            } else if (num > 5) {
                cnt += 10 - num;
                storey++;
            } else {
                //만약 5일때 앞자리가 5 이상이라면 올린다.
                if (storey % 10 >= 5) {
                    cnt += 5;
                    storey++;
                } 
                //앞자리가 5보다 작다면 내린다.
                else {
                    cnt += 5;
                }
            }
        }
        return cnt;
    }
}