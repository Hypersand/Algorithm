import java.util.*;

class Solution {
    private static int[][] moveCntArr;
    private static String[][] arr;
    private static int N, M;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static Node start;
    private static Node end;
    private static final int INF = 1000000;
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        moveCntArr = new int[N][M];
        arr = new String[N][M];
        for (int i = 0; i < board.length; i++) {
            String[] rowArr = board[i].split("");
            for (int j = 0; j < rowArr.length; j++) {
                arr[i][j] = rowArr[j];
                moveCntArr[i][j] = INF;
                if (arr[i][j].equals("R")) {
                    start = new Node(i, j);
                    continue;
                }
                
                if (arr[i][j].equals("G")) {
                    end = new Node(i, j);
                }
            }
        }
        
        find();
        if (moveCntArr[end.x][end.y] == INF) return -1;
        return moveCntArr[end.x][end.y];
    }
    
    private static void find() {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            int nx = start.x + dx[i];
            int ny = start.y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (arr[nx][ny].equals("D")) continue;
            queue.add(new Node(nx, ny, i, 1));
        }
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int nx = node.x + dx[node.dir];
            int ny = node.y + dy[node.dir];
            // 이동하던 방향으로 더 이상 갈 수 없다면??
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny].equals("D")) {
                if (moveCntArr[node.x][node.y] < node.cnt) continue;
                // 현재 위치가 G인지 판별
                if (node.x == end.x && node.y == end.y) {
                    moveCntArr[end.x][end.y] = Math.min(moveCntArr[end.x][end.y], node.cnt);
                    continue;
                }
                
                moveCntArr[node.x][node.y] = node.cnt;
                // 현재 위치가 G가 아니라면, 방향 전환
                for (int i = 0; i < 4; i++) {
                    if (i == node.dir) continue;
                    if (node.dir == 0 && i == 1) continue;
                    if (node.dir == 1 && i == 0) continue;
                    if (node.dir == 2 && i == 3) continue;
                    if (node.dir == 3 && i == 2) continue;
                    queue.add(new Node(node.x, node.y, i, node.cnt + 1));
                }
                
                continue;
            }
            
            // 이동하던 방향으로 진행 가능하면 계속 진행
            queue.add(new Node(nx, ny, node.dir, node.cnt));
        }
        
        
    }
    
    private static class Node {
        private int x;
        private int y;
        private int dir;
        private int cnt;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public Node(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
}
