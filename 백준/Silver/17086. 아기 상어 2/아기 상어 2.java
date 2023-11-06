import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static int[][] map2;
    private static boolean[][] visited;
    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    private static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        map2 = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int maxDistance = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                    map2[nx][ny] = map2[p.x][p.y] + 1;
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    maxDistance = Math.max(map2[nx][ny], maxDistance);
                }
            }
        }
        return maxDistance;
    }
}
