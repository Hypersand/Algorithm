import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[][] arr;
    private static int[][] arr2;
    private static boolean[][] visited;
    private static int goal_row = 0;
    private static int goal_col = 0;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        arr2 = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int goal = Integer.parseInt(st.nextToken());
                if (goal == 2) {
                    goal_row = i;
                    goal_col = j;
                }

                arr[i][j] = goal;
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && arr2[i][j] == 0) {
                    arr2[i][j] = -1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : arr2) {
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(goal_row, goal_col));
        visited[goal_row][goal_col] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int n_x = p.x + dx[i];
                int n_y = p.y + dy[i];
                if (n_x >= 0 && n_y >= 0 && n_x < n && n_y < m) {
                    if (!visited[n_x][n_y] && arr[n_x][n_y] != 0) {
                        queue.add(new Point(n_x, n_y));
                        arr2[n_x][n_y] = arr2[p.x][p.y] + 1;
                        visited[n_x][n_y] = true;
                    }
                }
            }
        }
    }
}
