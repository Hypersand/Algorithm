import java.util.*;
class Solution {
    private static int N;
    private static int[] visited; //방문한 열, 행 체크
    private static int cnt = 0;
    public int solution(int n) {
        visited = new int[n];
        for (int i = 0; i<n; i++) {
            visited[i] = -1;
        }
        N = n;
        game(0);
        return cnt;
    }
    
    private static void game(int row) {
        if (row == N) {
            cnt++;
            return;
        }
        
        for (int i = 0; i<N; i++) {
            visited[row] = i;
            if (validate(row, i)) {
                game(row + 1);
            }
        }
        
    }
    
    private static boolean validate(int row, int col) {
        for (int i = 0; i<row; i++) {
            //이미 같은 열에 놓았으면 false 반환
            if (visited[i] == visited[row]) return false;
            //이미 같은 대각선에 놓았으면 false 반환
            if (Math.abs((i - row)) == Math.abs(visited[i] - col)) {
                return false;
            }
        }
        
        return true;
    }
 }