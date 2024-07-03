import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[T + 1];
        int[][][] dp = new int[T + 1][3][W + 1];

        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1][1][0] = arr[1] == 1 ? 1 : 0;
        int max = dp[1][1][0];
        if (W > 0) {
            dp[1][2][1] = arr[1] == 2 ? 1 : 0;
            max = Math.max(max, dp[1][2][1]);
        }

        for (int i = 2; i <= T; i++) {
            for (int j = 1; j <= 2; j++) {
                for (int k = 0; k <= W; k++) {
                    if (i - k <= 0) break;
                    dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);
                    if (j == 1) {
                        if (k > 0) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][2][k - 1]);
                        }
                    } else {
                        if (k > 0) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][1][k - 1]);
                        }
                    }

                    if (j == arr[i]) {
                        dp[i][j][k] += 1;
                    }

                    max = Math.max(dp[i][j][k], max);
                }
            }
        }

        System.out.println(max);
    }
}
