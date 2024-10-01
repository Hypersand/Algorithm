import java.util.*;

class Solution {
    boolean solution(String s) {
        int openCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openCnt++;
                continue;
            }
            
            if (openCnt == 0) return false;
            openCnt--;
        }
        
        if (openCnt != 0) return false;
        return true;
    }
}