import java.lang.Math;

class Solution {
    public long solution(long n) {
        long number = (long)Math.sqrt(n);
        if(n == (long)Math.pow(number,2)) {
            return (long)Math.pow((number+1),2);
        }
        return -1;

    }
}