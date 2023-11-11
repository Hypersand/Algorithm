import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int max = 0;
    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                find(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private static void find(int row, int col, int sum, int cnt) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                if (cnt == 2) {
                    visited[nx][ny] = true;
                    find(row, col, sum + map[nx][ny], cnt + 1);
                    visited[nx][ny] = false;
                }

                visited[nx][ny] = true;
                find(nx, ny, sum + map[nx][ny], cnt + 1);
                visited[nx][ny] = false;
            }
        }
    }

}
