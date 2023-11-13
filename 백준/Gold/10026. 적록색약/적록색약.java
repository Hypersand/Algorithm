import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int N;
    private static String[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        //bfs1 : 적록색약 X
        //bfs2 : 적록색약 O

        int cnt1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    cnt1++;
                    bfs1(i, j);
                }
            }
        }

        int cnt2 = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    cnt2++;
                    bfs2(i, j);
                }
            }
        }

        System.out.println(cnt1 + " " + cnt2);
    }

    private static void bfs1(int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col));
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[p.x][p.y].equals(map[nx][ny])) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static void bfs2(int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col));
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] ) {
                    if (map[p.x][p.y].equals("R") || map[p.x][p.y].equals("G")) {
                        if (map[nx][ny].equals("R") || map[nx][ny].equals("G")) {
                            queue.add(new Point(nx, ny));
                            visited[nx][ny] = true;
                        }
                    } else {
                        if (map[p.x][p.y].equals(map[nx][ny])) {
                            queue.add(new Point(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }

    }
}
