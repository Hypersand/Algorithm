import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int second = 0;
    private static int[][] arr;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static Map<Integer, String> map = new HashMap<>();
    private static boolean[][] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        used = new boolean[N][N];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            arr[row-1][col-1] = -1;
        }
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            map.put(X, C);
        }
        System.out.println(snakeGame());
    }

    private static int snakeGame() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        used[0][0] = true;
        int direction = 1; // 0 : 상, 1 : 우, 2 : 하, 3 : 좌
        int x = 0;
        int y = 0;

        while (true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            second++;
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || used[nx][ny]) {
                return second;
            }

            queue.add(new Point(nx, ny));
            used[nx][ny] = true;

            if (arr[x][y] == -1) {
                arr[x][y] = 0;

            } else {
                Point p = queue.poll();
                used[p.x][p.y] = false;
            }

            if (map.containsKey(second)) {
                if (map.get(second).equals("D")) {
                    if (direction == 3) {
                        direction = 0;
                    } else {
                        direction += 1;
                    }

                } else {
                    if (direction == 0) {
                        direction = 3;
                    } else {
                        direction -= 1;
                    }
                }
            }

            x = nx;
            y = ny;
        }
    }
}
