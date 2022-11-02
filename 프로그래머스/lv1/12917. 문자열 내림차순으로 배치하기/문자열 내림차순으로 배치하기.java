import java.util.*;

class Solution {
    public String solution(String s) {
        char [] arr = new char[s.length()];
        String ans = "";
        
        
        for(int i = 0; i<s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        
        for(int i = 0; i<arr.length; i++) {
            for(int j = i+1; j<arr.length; j++) {
                if(arr[i] < arr[j]) {
                    char tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            ans += arr[i];
        }
        
        return ans;
    }
}