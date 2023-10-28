import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int maxSize = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r-1][c-1] = -1;
        }
        bfs();
        System.out.println(maxSize);
    }

    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == -1 && !visited[i][j]) {
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                    int cnt = 1;
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != -1 || visited[nx][ny]) continue;
                            visited[nx][ny] = true;
                            cnt++;
                            queue.add(new Point(nx, ny));
                        }
                    }
                    maxSize = Math.max(cnt, maxSize);
                }
            }
        }
    }
}
