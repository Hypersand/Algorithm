import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int [] answer = new int[commands.length];
        
        for(int i = 0; i<commands.length; i++) {
            int [] newArray = new int[commands[i][1] - commands[i][0] + 1];
            int k = commands[i][0] - 1;
            for(int j = 0; j<newArray.length; j++) {
                newArray[j] = array[k];
                k++;
            }
            Arrays.sort(newArray);
            answer[i] = newArray[commands[i][2]-1];
        }
        
        
        return answer;
    }
}