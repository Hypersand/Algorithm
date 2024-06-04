import java.util.*;

class Solution {
    private static int[] dx = {-1, 1, 0, 0}; // 상 하
    private static int[] dy = {0, 0, -1, 1}; // 좌 우
    private static int[][][] costs;
    private static final int INF = 10000000;
    public int solution(int[][] board) {
        costs = new int[board.length][board[0].length][4];
        for (int i = 0; i<costs.length; i++) {
            for (int j = 0; j<costs[i].length; j++) {
                for (int k = 0; k<4; k++) {
                    costs[i][j][k] = INF;
                }
            }
        }
        bfs(board);
        
        int min = INF;
        for (int i = 0; i<4; i++) {
            min = Math.min(min, costs[costs.length - 1][costs[0].length - 1][i]);
        }
        
        return min;
    }
    
    private void bfs(int[][] board) {
        for (int i = 0; i<4; i++) {
            costs[0][0][i] = 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, -1, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 상 하 좌 우
            for (int i = 0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) {
                    continue;
                }
                if (board[nx][ny] == 1) continue;
                
                // 방문하려는 지점으로 갔을때 현재 진행 방향과 평행한지 수직인지 확인
                int newCost = cur.cost;
                if ((cur.dir == 0 || cur.dir == 1) && (i == 2 || i == 3)) {
                    newCost += 600;
                } else if ((cur.dir == 2 || cur.dir == 3) && (i == 0 || i == 1)) {
                    newCost += 600;
                } else {
                    newCost += 100;
                }
                
                if (costs[nx][ny][i] <= newCost) continue;
                costs[nx][ny][i] = newCost;
                queue.add(new Node(nx, ny, i, newCost));   
            }
        }
        
    }
    
    private static class Node {
        private int x;
        private int y;
        private int dir;
        private int cost;
        
        public Node (int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
}