
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int [] dx = {-1,-2,-2,-1,1,2,2,1};
    private static int [] dy = {-2,-1,1,2,-2,-1,1,2};
    private static int [][] arr;
    private static boolean [][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int [] knight = new int [2];
        int [] goal = new int [2];
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int [n][n];
            visited = new boolean[n][n];

            st = new StringTokenizer(br.readLine());
            knight[0] = Integer.parseInt(st.nextToken());
            knight[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            goal[0] = Integer.parseInt(st.nextToken());
            goal[1] = Integer.parseInt(st.nextToken());

            bfs(knight,goal);
            sb.append(arr[goal[0]][goal[1]] + "\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int [] knight, int [] goal) {
        visited[knight[0]][knight[1]] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(knight[0], knight[1]));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx>=0&&ny>=0&&nx<arr.length&&ny<arr[0].length) {
                    if(!visited[nx][ny]) {
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        arr[nx][ny] = arr[p.x][p.y] + 1;
                        if(goal[0] == nx && goal[1] == ny) break;
                    }
                }
            }
        }



    }
}
