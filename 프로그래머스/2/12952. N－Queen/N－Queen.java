import java.util.*;
class Solution {
    private static int[] pos;
    private static int N;
    private static int cnt;
    public int solution(int n) {
        pos = new int[n];
        N = n;
        move(0);
        return cnt;
    }
    
    private static void move(int idx) {
        if (idx == N) {
            cnt++;
            return;
        }
        
        for (int i = 0; i<N; i++) {
            if (validate(idx, i)) {
                pos[idx] = i;
                move(idx + 1);
            }
        }
    }
    
    //열, 대각선 검증
    private static boolean validate(int row, int col) {
        for (int i = 0; i<row; i++) {
            //열 검증
            if (pos[i] == col) return false;
            //대각선 검증
            if (Math.abs(i - row) - Math.abs(pos[i] - col) == 0) {
                return false;
            }
        }
        
        return true;
    }
}