import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static String[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            map[i] = line.split("");
        }

        System.out.println(bfs("W") + " " + bfs("B"));
    }

    private static int bfs(String color) {
        Queue<Point> queue = new LinkedList<>();
        int size = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].equals(color) && !visited[i][j]) {
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                    int cnt = 1;
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int now_x = p.x + dx[k];
                            int now_y = p.y + dy[k];
                            if (now_x < 0 || now_y < 0 || now_x >= M || now_y >= N || !map[now_x][now_y].equals(color) || visited[now_x][now_y]) {
                                continue;
                            }

                            queue.add(new Point(now_x, now_y));
                            cnt++;
                            visited[now_x][now_y] = true;
                        }
                    }
                    size += cnt * cnt;
                }
            }
        }
        return size;
    }
}
