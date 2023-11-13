import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static String[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("L")) {
                    visited = new boolean[N][M];
                    bfs(i, j);
                }
            }
        }

        System.out.println(max);
    }

    private static void bfs(int x, int y) {
        int[][] arr = new int[N][M];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny].equals("L")) {
                    queue.add(new Point(nx, ny));
                    arr[nx][ny] = arr[p.x][p.y] + 1;
                    max = Math.max(arr[nx][ny], max);
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
