import java.util.*;

class Solution {
    public int solution(int[] a) {
        int[] leftMinArr = new int[a.length];
        int[] rightMinArr = new int[a.length];
        leftMinArr[0] = a[0];
        rightMinArr[a.length - 1] = a[a.length - 1];
        for (int i = 1; i<a.length; i++) {
            if (a[i] < leftMinArr[i - 1]) {
                leftMinArr[i] = a[i];
            } else {
                leftMinArr[i] = leftMinArr[i - 1];
            }
        }
        
        for (int i = a.length - 2; i>=0; i--) {
            if (rightMinArr[i + 1] > a[i]) {
                rightMinArr[i] = a[i];
            } else {
                rightMinArr[i] = rightMinArr[i + 1];
            }
        }
        
        int answer = 0;
        for (int i = 0; i<a.length; i++) {
            int cnt = 0;
            if (i - 1 >= 0) {
                if (leftMinArr[i - 1] < a[i]) cnt++;
            }
            
            if (i + 1 < a.length) {
                if (rightMinArr[i + 1] < a[i]) cnt++;
            }
            
            if (cnt <= 1) answer++;
        }
        
        return answer;
    }
}