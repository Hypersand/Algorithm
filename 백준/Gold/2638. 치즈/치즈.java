import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[][] isAir;
    private static List<Point> nearAirCheeses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        int cheeseCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheeseCnt++;
            }
        }

        if (cheeseCnt == 0) {
            System.out.println(0);
            return;
        }

        int time = 0;
        while (true) {
            // 외부 공기 탐색
            isAir = new boolean[N][M];
            findAir();

            // 외부 공기와 맞닿는 치즈 탐색
            nearAirCheeses = new ArrayList<>();
            findNearAirCheese();

            // 외부 공기와 2면 이상 맞닿는 치즈 삭제
            for (Point nearAirCheese : nearAirCheeses) {
                map[nearAirCheese.x][nearAirCheese.y] = 0;
            }

            // 치즈가 존재하는지 확인
            boolean cheeseFlag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        cheeseFlag = true;
                        break;
                    }
                }

                if (cheeseFlag) break;
            }

            time++;
            if (!cheeseFlag) break;
        }

        System.out.println(time);

    }

    private static void findNearAirCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    int cnt = 0;
                    for (int t = 0; t < 4; t++) {
                        int nx = i + dx[t];
                        int ny = j + dy[t];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if (isAir[nx][ny]) cnt++;
                    }

                    if (cnt >= 2) {
                        nearAirCheeses.add(new Point(i, j));
                    }
                }
            }
        }
    }

    private static void findAir() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        isAir[0][0] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 1 || isAir[nx][ny]) continue;
                isAir[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }
    }
}
