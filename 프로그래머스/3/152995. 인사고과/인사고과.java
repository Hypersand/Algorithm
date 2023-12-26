import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        //완호의 등수를 구해야한다. 완호는 scores[0]
        for (int i = 0; i<scores.length; i++) {
            if (scores[0][0] < scores[i][0] && scores[0][1] < scores[i][1]) {
                return -1;
            }
        }
        
        int answer = 1;
        for (int i = 1; i<scores.length; i++) {
            if (scores[0][0] + scores[0][1] < scores[i][0] + scores[i][1]) {
                boolean canIncentive = true;
                for (int j = 1; j<scores.length; j++) {
                    if (scores[i][0] <scores[j][0] && scores[i][1] < scores[j][1]) {
                        canIncentive = false;
                        break;
                    }
                }
                if (canIncentive) answer++;
            }
        }
        
        return answer;
    }
    
    private static class Score {
        int idx;
        int score;
    }
}