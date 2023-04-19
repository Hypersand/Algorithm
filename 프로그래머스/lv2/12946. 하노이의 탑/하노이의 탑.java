import java.util.*;

class Solution {
    
    public static int i = 0;
    
    public int[][] answer;
    
    public int[][] solution(int n) {
        
        int size = (int)Math.pow(2, n) - 1;
        
        answer = new int[size][2];
        
        hanoi(1,2,3,n);
        
        return answer;
    }
    
    
    public void hanoi(int start, int mid , int end, int n) {
        if (n == 1) {
            answer[i][0] = start;
            answer[i][1] = end;
            i++;
            return;
        }
        
        hanoi(start, end, mid, n-1);
        answer[i][0] = start;
        answer[i][1] = end;
        i++;
        hanoi(mid, start, end, n-1);
        
    }
}