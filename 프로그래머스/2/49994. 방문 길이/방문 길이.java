import java.util.*;
class Solution {
    private static int[] dx = {-1,1,0,0}; //상하
    private static int[] dy = {0,0,-1,1}; //좌우
    private static boolean[][][][] visited;
    private static String[] dirArr;
    public int solution(String dirs) {
        visited = new boolean[11][11][11][11];
        dirArr = dirs.split("");
        return move();
    }
    private static int move() {
        int length = 0;
        int x = 5;
        int y = 5;
        for (int i = 0; i< dirArr.length; i++) {
            int nx = 0;
            int ny = 0;
            if (dirArr[i].equals("U")) {
                nx = x + dx[0];
                ny = y + dy[0];
            } else if (dirArr[i].equals("D")) {
                nx = x + dx[1];
                ny = y + dy[1];
                
            } else if (dirArr[i].equals("L")) {
                nx = x + dx[2];
                ny = y + dy[2];
                
            } else {
                nx = x + dx[3];
                ny = y + dy[3];
            }
            //(x,y) -> (nx,ny) 검증
            if (nx < 0 || ny < 0 || nx > 10 || ny > 10) continue;
            if (!visited[x][y][nx][ny]) {
                visited[x][y][nx][ny] = true;
                visited[nx][ny][x][y] = true;
                length++;
            }
            x = nx;
            y = ny;
        }
        
        return length;
    }
}