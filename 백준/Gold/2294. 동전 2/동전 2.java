import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);

        int[] dp = new int[k + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < coins.length; j++) {
                if (i - coins[j] < 0) break;
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }

        if (dp[k] == INF) {
            System.out.println(-1);
            return;
        }

        System.out.println(dp[k]);
    }
}
