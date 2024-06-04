import java.util.*;

class Solution {
    private static final int INF = 10000000;
    public int solution(int n, int[][] results) {
        int[][] arr1 = new int[n+1][n+1]; // 위로 올라가는 그래프
        int[][] arr2 = new int[n+1][n+1]; // 아래로 내려가는 그래프
        for (int i = 1; i<=n; i++) {
            Arrays.fill(arr1[i], INF);
            Arrays.fill(arr2[i], INF);
        }
        
        
        for (int i = 0; i<results.length; i++) {
            int start = results[i][0];
            int end = results[i][1];
            arr2[start][end] = 1;
            arr1[end][start] = 1;
        }
        
        for (int k = 1; k<=n; k++) {
            for (int i = 1; i<=n; i++) {
                for (int j = 1; j<=n; j++) {
                    if (i == j) continue;
                    if (arr1[i][k] == 1 && arr1[k][j] == 1) {
                        arr1[i][j] = 1;
                    }
                    
                    if (arr2[i][k] == 1 && arr2[k][j] == 1) {
                        arr2[i][j] = 1;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i<=n; i++) {
            int cnt = 0;
            for (int j = 1; j<=n; j++) {
                if (i == j) continue;
                if (arr1[i][j] == 1 || arr2[i][j] == 1) cnt++;
            }
            
            if (cnt == n - 1) answer++;
        }
        
        return answer;
    }
}