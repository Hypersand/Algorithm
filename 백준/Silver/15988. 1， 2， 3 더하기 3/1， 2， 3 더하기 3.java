import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static long[] dp;
    private static final int INF = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new long[n + 10];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int j = 4; j <= n; j++) {
                dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % INF;
            }

            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}
