import java.util.*;
class Solution {
    public int solution(String s) {
        int maxSize = s.length() / 2;
        int minLength = s.length();
        for (int i = 0; i<=maxSize; i++) { 
            String str1 = s.substring(0, i + 1);
            String str2 = "";
            String newStr = "";
            int cnt = 1;
            int lastIdx = 0;
            for (int j = i + 1; j< s.length() - i; j+=i+1) {
                str2 = s.substring(j, j+i+1);
                lastIdx = j + i + 1;
                if (str1.equals(str2)) {
                     cnt++;
                } else {
                    if (cnt == 1) {
                        newStr += str1;
                    } else {
                        newStr += cnt + str1;
                    }
                    cnt = 1;
                    str1 = str2;
                }
            }
            if (cnt == 1) {
                newStr += str2;
            } else {
                newStr += cnt + str2;
            }
            
            if (lastIdx > 0) {
                newStr += s.substring(lastIdx, s.length());
            }
            if (newStr.length() == 0) continue;
            minLength = Math.min(newStr.length(), minLength);
        }
        return minLength;
    }
}