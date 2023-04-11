
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[][] arr;
    public static boolean[][] flooding;
    public static boolean[][] visited;

    public static int N;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int maxNumber = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxNumber = Math.max(maxNumber, arr[i][j]);
            }
        }


        if (maxNumber == 1) {
            System.out.println(1);
        } else {
            int maxCount = 0;

            for (int t = 1; t < maxNumber; t++) {
                flooding = new boolean[N][N];
                visited = new boolean[N][N];

//                for (int i = 0; i < N; i++) {
//                    for (int j = 0; j < N; j++) {
//                        if (arr[i][j] <= t) {
//                            flooding[i][j] = true;
//                        }
//                    }
//                }

                maxCount = Math.max(find(t), maxCount);
            }

            System.out.println(maxCount);
        }
    }

    public static int find(int rainCount) {

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] > rainCount && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    queue.add(new Point(i, j));
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();

                        for (int t = 0; t < 4; t++) {
                            int nx = p.x + dx[t];
                            int ny = p.y + dy[t];
                            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                                if (arr[nx][ny] > rainCount && !visited[nx][ny]) {
                                    queue.add(new Point(nx, ny));
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                }

            }

        }
        return count;
    }
}
