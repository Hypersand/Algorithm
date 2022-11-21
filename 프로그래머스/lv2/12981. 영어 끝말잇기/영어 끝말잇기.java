
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int [] answer = new int [2];
        List<String> list = new ArrayList<>();
        for(int i=0;i<words.length;i++){
        
            if(i>=1){
                if(words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)){
                    answer[0]=i%n+1;
                    answer[1]=i/n+1;
                    return answer;
                }
            }

            if(list.contains(words[i])){
                answer[0]=i%n+1;
                answer[1]=i/n+1;
                return answer;
            }
            list.add(words[i]);
        }

        return answer;
    }
      
   }

    
