import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int n;
    private static int[][] arr;
    private static int[][] destroyArr;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        destroyArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            Arrays.fill(destroyArr[i], -1);
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        bfs();
        System.out.println(destroyArr[n - 1][n - 1]);
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        destroyArr[0][0] = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                //검은 방일 경우
                if (arr[nx][ny] == 0) {
                    if (destroyArr[nx][ny] == -1 || destroyArr[nx][ny] > destroyArr[p.x][p.y] + 1) {
                        destroyArr[nx][ny] = destroyArr[p.x][p.y] + 1;
                        queue.add(new Point(nx, ny));
                    }
                    continue;
                }

                //흰 방일 경우
                if (destroyArr[nx][ny] == -1 || destroyArr[nx][ny] > destroyArr[p.x][p.y]) {
                    destroyArr[nx][ny] = destroyArr[p.x][p.y];
                    queue.add(new Point(nx, ny));
                }
            }

        }
    }
}
