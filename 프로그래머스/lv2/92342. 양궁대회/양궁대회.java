import java.util.*;

class Solution {
    
    public int maxDiff = 0;
    public int[] finalAnswer = new int[11];
    
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        select(0, 0, answer ,info, n);
        
        if (maxDiff == 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        return finalAnswer;
    }
    
    
    public void select(int idx, int count, int[] answer, int[] info, int n) {
        if (count == n) {
            
            int lion = 0;
            int apeach = 0;
            
            for (int i = 0; i<=10; i++) {
                if (answer[i]==0 && info[i]==0) {
                    continue;
                }
                
                if (answer[i]>info[i]) {
                    lion += 10 - i;
                }
                if (answer[i]<=info[i]) {
                    apeach += 10 - i;
                }
            }
            
            int diff = lion - apeach;
            
            if (diff <= 0) {
                return;
            }
            
            else {
                if (diff < maxDiff) {
                    return;
                }
                
                if (diff == maxDiff) {
                    for (int i = 10; i>=0; i--) {
                        if (answer[i]>finalAnswer[i]) {
                            for (int j = 0; j<=10; j++) {
                                finalAnswer[j] = answer[j];
                            }
                            return;
                        }
                        if (answer[i]<finalAnswer[i]) {
                            return;
                        }
                    }
                    return;
                }
                
                if (diff > maxDiff) {
                    maxDiff = diff;
                    for (int i = 0; i<=10; i++) {
                        finalAnswer[i] = answer[i];
                    }
                    return;
                }
                
            }
            return;
        }
            
        for (int i = idx; i<=10; i++) {
            if(answer[i]>info[i]) {
                continue;
            }
            answer[i]++;
            select(i, count+1, answer, info, n);
            answer[i]--;
        }
    }
}

