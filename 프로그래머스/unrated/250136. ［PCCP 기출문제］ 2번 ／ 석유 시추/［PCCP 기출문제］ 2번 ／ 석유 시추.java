import java.util.*;
class Solution {
    private static boolean[][] visited;
    private static int[][] oilArr;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public int solution(int[][] land) {
        Map<Integer, Integer> oilMap = new HashMap<>();
        visited = new boolean[land.length][land[1].length];
        oilArr = new int[land.length][land[0].length];
        int oilNumber = 1;
        for (int i = 0; i<land.length; i++) {
            for (int j = 0; j<land[i].length; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    int cnt = bfs(land, oilNumber, i, j);
                    oilMap.put(oilNumber, cnt);
                    oilNumber++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i<land[0].length; i++) {
            boolean[] used = new boolean[oilNumber + 1];
            int sum = 0;
            for (int j = 0; j<land.length; j++) {
                if (land[j][i] == 1 && !used[oilArr[j][i]]) {
                    used[oilArr[j][i]] = true;
                    sum += oilMap.get(oilArr[j][i]);
                }
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
    private static int bfs(int[][] land, int oilNumber, int x, int y) {
        int cnt = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y] = true;
        oilArr[x][y] = oilNumber;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i<4; i++) {
                int now_x = node.x + dx[i];
                int now_y = node.y + dy[i];
                if (now_x >= 0 && now_y >= 0 && now_x < oilArr.length 
                    && now_y < oilArr[0].length) {
                    if(!visited[now_x][now_y] && land[now_x][now_y] == 1) {
                        visited[now_x][now_y] = true;
                        oilArr[now_x][now_y] = oilNumber;
                        queue.add(new Node(now_x, now_y));
                        cnt++;
                    }
                }
            }
        }
        
        return cnt;
    }
    
    private static class Node {
        int x;
        int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}