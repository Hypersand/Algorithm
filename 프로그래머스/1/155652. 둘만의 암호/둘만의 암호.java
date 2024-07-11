import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] isSkip = new boolean[124];
        for (int i = 0; i < skip.length(); i++) {
            isSkip[skip.charAt(i)] = true;
        }
        
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            char changeWord = word;
            int cnt = 0;
            while (true) {
                // 이동이 가능한 상황
                // 1. 현재 칸이 skip칸일 때 
                if (isSkip[changeWord]) {
                    changeWord += 1;
                    if (changeWord > 'z') {
                        changeWord = 'a';
                    }
                    continue;
                }
                // 2. index보다 덜 넘었을때
                if (cnt < index) {
                    changeWord += 1;
                    if (changeWord > 'z') {
                        changeWord = 'a';
                    }
                    cnt++;
                    continue;
                }
                
                break;
            }
            
            answer += changeWord;
        }
        
    
        return answer;
    }
}