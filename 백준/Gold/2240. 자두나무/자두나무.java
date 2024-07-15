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
        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][][] dp = new int[T + 1][3][W + 1];
        if (arr[1] == 1) {
            dp[1][1][0] = 1;
        } else {
            dp[1][2][1] = 1;
        }

        int answer = 1;
        for (int t = 2; t <= T; t++) {
            for (int i = 1; i <= 2; i++) {
                for (int j = 0; j <= W; j++) {
                    if (j == 0) {
                        if (i == arr[t]) {
                            dp[t][i][j] = dp[t - 1][i][j] + 1;
                        } else {
                            dp[t][i][j] = dp[t - 1][i][j];
                        }
                    } else {
                        if (i == arr[t]) {
                            dp[t][i][j] = Math.max(dp[t - 1][i][j], dp[t - 1][2 / i][j - 1]) + 1;
                        } else {
                            dp[t][i][j] = Math.max(dp[t - 1][i][j], dp[t - 1][2 / i][j - 1]);
                        }
                    }
                    answer = Math.max(answer, dp[t][i][j]);

                }
            }
        }
        System.out.println(answer);
    }
}
