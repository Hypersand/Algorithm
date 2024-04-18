import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n + 5][4];
            dp[1][1] = 1;
            dp[2][1] = 1;
            dp[2][2] = 1;
            dp[3][1] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;
            for (int j = 4; j <= n; j++) {
                dp[j][1] = dp[j - 1][1];
                dp[j][2] = dp[j - 2][1] + dp[j - 2][2];
                dp[j][3] = dp[j - 3][1] + dp[j - 3][2] + dp[j - 3][3];
            }

            sb.append(dp[n][1] + dp[n][2] + dp[n][3]).append("\n");
        }

        System.out.println(sb);
    }
}
