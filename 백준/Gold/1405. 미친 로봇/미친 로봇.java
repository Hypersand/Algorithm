import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static double[] per;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static double answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        per = new double[4];
        for (int i = 0; i < 4; i++) {
            per[i] = Integer.parseInt(st.nextToken()) / (double)100;
        }
        visited = new boolean[N * 2 + 1][N * 2 + 1];
        visited[N][N] = true;
        permutation(0, N, N, 1);
        System.out.println(answer);
    }

    private static void permutation(int idx, int x, int y, double p) {
        if (idx == N) {
            answer += p;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                permutation(idx + 1, nx, ny, p * per[i]);
                visited[nx][ny] = false;
            }

        }


    }
}
