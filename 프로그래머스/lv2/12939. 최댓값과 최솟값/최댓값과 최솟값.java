import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        String [] arr1 = s.split(" ");
        int [] arr = new int [arr1.length];

        for(int i = 0; i<arr1.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        return arr[0] + " " + arr[arr.length-1];
    }
}