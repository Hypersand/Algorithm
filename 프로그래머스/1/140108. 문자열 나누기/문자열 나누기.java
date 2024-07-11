import java.util.*;

class Solution {
    public int solution(String s) {
        int firstWordCnt = 0;
        int otherWordCnt = 0;
        boolean isFirst = true;
        char firstWord = ' ';
        int answer = 1;
        for (int i = 0; i<s.length(); i++) {
            if (isFirst) {
                firstWord = s.charAt(i);
                firstWordCnt++;
                isFirst = false;
                continue;
            } 
            
            if (s.charAt(i) == firstWord) {
                firstWordCnt++;
                continue;
            } 
            
            otherWordCnt++;
            if (firstWordCnt == otherWordCnt) {
                // 마지막 단어에서 같아질 경우 분리 안된다.
                if (i == s.length() - 1) continue;
                firstWordCnt = 0;
                otherWordCnt = 0;
                isFirst = true;
                answer++;
            }
        }
        
        return answer;
    }
}