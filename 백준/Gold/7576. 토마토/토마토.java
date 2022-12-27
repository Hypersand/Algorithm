
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static  int [][] arr;
    private static int [][] arr2;
    private static boolean [][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int day = 0;
    private static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        arr2 = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) {
                    visited[i][j] = true;
                    queue.add(new Point(i, j));
                }
            }
        }

        bfs();

        for (int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                if(!visited[i][j]&&arr[i][j]==0) day = -1;
            }
        }

        System.out.println(day);
    }

    private static void bfs() {


        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx>=0&&ny>=0&&nx<arr.length&&ny<arr[0].length) {
                    if(!visited[nx][ny]&&arr[nx][ny]!=-1) {
                        visited[nx][ny] = true;
                        arr2[nx][ny] = arr2[p.x][p.y] + 1;
                        day = Math.max(arr2[nx][ny], day);
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
