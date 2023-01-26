
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int [][] arr;
    private static long [][] dp;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(jump(0, 0));

    }

    private static long jump(int x, int y) {
        if (x == N - 1 && y == N - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        for (int i = 0; i < 2; i++) {
            int nx = x;
            int ny = y;
            if (i == 0) {
                nx = x + arr[x][y];
            }
            if (i == 1) {
                ny = y + arr[x][y];
            }
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                dp[x][y] += jump(nx, ny);
            }
        }

        return dp[x][y];
    }
}
