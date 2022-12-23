
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int [][] arr = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int [] count = new int[3];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i<3; i++) {
            int t = 0;
            for(int j = 0; j<answers.length; j++) {
                if(t>arr[i].length-1) t=0;
                if(arr[i][t]==answers[j]) {
                    count[i]++;
                }
                t++;
            }
        }
        
       int max = 0;
       int resultCount = 0;
        
       for(int i = 0; i<3; i++) {
           if(count[i]>max) max = count[i];
       }
       
       for(int i = 0; i<3; i++) {
           if(max == count[i]) {
               resultCount++;
               list.add(i+1);
           }
           
       }
       
       int [] answer = new int[resultCount];
       for(int i = 0; i<answer.length; i++) {
           answer[i] = list.get(i).intValue();
       }
        
       
        return answer;
    }
}