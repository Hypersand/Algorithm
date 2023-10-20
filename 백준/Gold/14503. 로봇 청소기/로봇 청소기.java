import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int x, y;
    private static int[][] map;
    private static boolean[][] isCleaned;
    private static int[] dx = {-1, 0, 1, 0}; // 행
    private static int[] dy = {0, 1, 0, -1}; // 열
    private static int cleanRoomCnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isCleaned = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(d);
        System.out.println(cleanRoomCnt);
    }

    public static void bfs(int direction) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        isCleaned[x][y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            boolean isClean = false;

            for (int i = 0; i < 4; i++) {
                if (direction == 0) {
                    direction = 3;
                } else {
                    direction -= 1;
                }

                int nx = p.x + dx[direction];
                int ny = p.y + dy[direction];

                if(map[nx][ny] == 1 || isCleaned[nx][ny]) continue;
                isCleaned[nx][ny] = true;
                cleanRoomCnt++;
                isClean = true;
                queue.add(new Point(nx, ny));
                break;
            }

            if (!isClean) {
                int nx = p.x - dx[direction];
                int ny = p.y - dy[direction];

                if(map[nx][ny] == 1)
                    break;

                queue.add(new Point(nx, ny));
            }
        }

    }
}
