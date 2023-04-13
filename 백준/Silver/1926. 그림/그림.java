
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static int[][] arr;
    public static boolean[][] visited;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int paintingCount = 0;
    public static int maxPaintingArea = 0;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        find();
        System.out.println(paintingCount);
        System.out.println(maxPaintingArea);
    }

    public static void find() {
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    int paintingArea = 1;
                    paintingCount++;
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        for (int t = 0; t < 4; t++) {
                            int nx = p.x + dx[t];
                            int ny = p.y + dy[t];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 1 && !visited[nx][ny]) {
                                queue.add(new Point(nx, ny));
                                visited[nx][ny] = true;
                                paintingArea++;
                            }
                        }
                    }
                    maxPaintingArea = Math.max(maxPaintingArea, paintingArea);
                }
            }
        }




    }

}
