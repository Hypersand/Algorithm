import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i<n; i++) {
            String str1 = Integer.toBinaryString(arr1[i]);
            StringBuilder sb = new StringBuilder();
            if (str1.length() < n) {
                for (int j = 0; j<n-str1.length(); j++) {
                    sb.append("0");
                }
                sb.append(str1);
                str1 = sb.toString();
            }
            String str2 = Integer.toBinaryString(arr2[i]);
            sb = new StringBuilder();
            if (str2.length() < n) {
                for (int j = 0; j<n-str2.length(); j++) {
                    sb.append("0");
                }
                sb.append(str2);
                str2 = sb.toString();
            }

            sb = new StringBuilder();
            for (int j = 0; j<n; j++) {
                if(str1.charAt(j) == '1' || str2.charAt(j) == '1') {
                    sb.append("#");
                    continue;
                }
                if(str1.charAt(j) == '0' && str2.charAt(j) == '0') {
                    sb.append(" ");
                    continue;
                }
            }
            answer[i] = sb.toString();
            
        }
        return answer;
    }
}