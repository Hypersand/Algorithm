import java.util.*;

class Solution {
    private static int[][] map;
    private static boolean[] visited;
    private static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        map = new int[dungeons.length][2];
        visited = new boolean[dungeons.length];
        for (int i = 0; i < map.length; i++) {
            map[i][0] = dungeons[i][0];
            map[i][1] = dungeons[i][1];
        }
        
        find(k, 0);
        
        return answer;
    }
    
    private static void find(int remain, int cnt) {
        answer = Math.max(answer, cnt);
        if (remain == 0) return;
        
        for (int i = 0; i < map.length; i++) {
            if (visited[i]) continue;
            if (remain < map[i][0]) continue;
            visited[i] = true;
            find(remain - map[i][1], cnt + 1);
            visited[i] = false;
        }
        
    }
}