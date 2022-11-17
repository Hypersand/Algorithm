import java.util.*;

class Solution {
    // n 보다 큰 자연수
    // 2진수로 변환했을때 n과 1의 갯수가 같다
    // 조건 1,2를 만족하는 가장 작은 수
    
    public int solution(int n) {
        int t = n + 1;
        int answer = 0;
        while (true) {
            if(binary(n)==binary(t)) {
                answer = t;
                break;
             }
            else {
                t++;
            }        
        }
        return answer;
        
    }
    
    public int binary(int k) {
        int count = 0;
        String s = Integer.toBinaryString(k);
        char [] arr = s.toCharArray();
        for(char a : arr) {
            if(a == '1')
                count++;
        }
        
        return count;
    }
}