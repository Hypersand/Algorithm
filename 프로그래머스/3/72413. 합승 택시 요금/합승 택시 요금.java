import java.util.*;

class Solution {
    private final int INF = 100000000;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[201][201];
        for (int i = 1; i<= 200; i++) {
            Arrays.fill(map[i], INF);
        }
        
        for (int i = 0; i<fares.length; i++) {
            map[fares[i][0]][fares[i][1]] = fares[i][2];
            map[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        for (int k = 1; k <= 200; k++) {
            for (int i = 1; i <= 200; i++) {
                for (int j = 1; j <= 200; j++) {
                    if (i == j) map[i][j] = 0;
                    if (map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i<=200; i++) {
            int dist = map[s][i];
            dist += map[i][a] + map[i][b];
            answer = Math.min(dist, answer);
        }
        
        return answer;
    }
    
    private static class Node {
        private int next;
        private int dist;
        public Node(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }
    }
}