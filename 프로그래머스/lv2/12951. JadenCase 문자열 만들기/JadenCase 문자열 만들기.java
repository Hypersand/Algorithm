import java.util.*;

class Solution {
    public String solution(String s) {
        String [] arr = s.split(" ", -1);
        String answer = "";
        
        for(int i = 0; i<arr.length; i++) {
            String [] arr2 = arr[i].split("");
            
                for (int j = 0; j<arr2.length; j++) {
                    if(j == 0) {
                        answer += arr2[j].toUpperCase();
                    }
                    else {
                        answer += arr2[j].toLowerCase();
                    }
                }
                    
        
            
            if(i<arr.length-1) {
                answer += " ";
            }
        
              
         }
        return answer;
    }
}