import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        
         //y^2 = r^2 - x^2
        // x = 1 부터 r2-1까지 차례차례 계산
        // 그거에 대한 Max Y와 Min y를 계산한다.
        // maxy^2 = r2^2 - x^2
        // miny^2 = r1^2 - x^2
        
        long answer = 0;
 
        for (int i=1; i<=r2; i++) {
            long minJ = (int) Math.ceil(Math.sqrt(1.0*r1*r1 - 1.0*i*i));
            long maxJ = (int) Math.floor(Math.sqrt(1.0*r2*r2 - 1.0*i*i));
 
            answer += (maxJ - minJ + 1);
 
        }
 
        return answer * 4;
    }
}