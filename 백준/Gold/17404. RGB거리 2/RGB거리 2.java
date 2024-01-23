import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 1000 * 1000 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[3][N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
            arr[2][i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[3][N+1];

        int min = Integer.MAX_VALUE;
        for (int t = 0; t < 3; t++) {
            for (int i = 0; i < 3; i++) {
                if (t == i) {
                    dp[i][1] = arr[i][1];
                } else {
                    dp[i][1] = INF;
                }
            }

            for (int i = 2; i <= N; i++) {
                dp[0][i] = Math.min(dp[1][i - 1], dp[2][i - 1]) + arr[0][i];
                dp[1][i] = Math.min(dp[0][i - 1], dp[2][i - 1]) + arr[1][i];
                dp[2][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + arr[2][i];
            }

            for (int i = 0; i < 3; i++) {
                if (t != i) {
                    min = Math.min(min, dp[i][N]);
                }
            }
        }

        System.out.println(min);
    }

}
