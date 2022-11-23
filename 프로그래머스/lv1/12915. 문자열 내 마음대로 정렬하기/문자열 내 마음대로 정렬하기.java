import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        for(int i = 0; i<strings.length-1; i++) {
            for(int j = i+1; j<strings.length; j++) {
                if(strings[i].charAt(n) > strings[j].charAt(n)) {
                    String tmp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = tmp;
                } 
                if (strings[i].charAt(n) == strings[j].charAt(n)) {
                    String [] arr = new String [2];
                    arr[0] = strings[i];
                    arr[1] = strings[j];
                    Arrays.sort(arr);
                    strings[i] = arr[0];
                    strings[j] = arr[1];
                } 
                    
            }
        }
            
        return strings;
       }
    }
