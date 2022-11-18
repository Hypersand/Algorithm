import java.util.*;

class Solution {
    public String solution(String s, int n) {
        char [] arr = s.toCharArray();
        String answer = "";
        for(int i = 0; i<arr.length; i++) {
            if(arr[i]=='z'||arr[i]=='Z') {
                answer += (char)(arr[i]-25+n-1);
            }
            else if(arr[i] == ' ') {
                answer += " ";
            }       
            else {
                if(arr[i]<'Z'&&arr[i]+n>'Z') {
                    answer += (char)(arr[i] + n - 26);
                }
                else if (arr[i]>='a'&& arr[i]+n >'z') {
                    answer += (char)(arr[i] + n - 26);
                }
                else {
                    answer += (char)(arr[i] + n);
                }
            }
        }
        
        return answer;
        
    }
}