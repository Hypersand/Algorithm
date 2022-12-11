

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int [][] arr;
    private static boolean [][] visited;
    private static int [] dx = {-1,1,0,0};
    private static int [] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i] = Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
        }
        bfs(0, 0);
        System.out.println(arr[N - 1][M - 1]);

    }


    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int a = queue.size();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length) {
                    if (!visited[nx][ny] && arr[nx][ny] != 0) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                        arr[nx][ny] = arr[p.x][p.y] + 1;
                    }
                }
            }
        }
    }
}
