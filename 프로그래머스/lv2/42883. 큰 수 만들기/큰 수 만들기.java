import java.util.*;

class Solution {
    //k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 문자열로 반환
    //2자리 <= number <= 100만자리
    //[4,1,7,7,2] [5,2,8,4,1] 두 그룹으로 나눈다.
    //왼쪽그룹에서 제일 큰 숫자를 뽑는다.
    //[7,2,5] [2,8,4,1] ans = 7
    //[2,5,2] [8,4,1]  ans = 77
    //[2,8] [4,1] ans = 775
    //[4] [1]  ans = 7758
    // 77584
    
    public String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        
        for(int i=0; i<number.length() - k; i++) {
            int max = 0;
            for(int j = idx; j<= k+i; j++) {
                
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
        
    }
}