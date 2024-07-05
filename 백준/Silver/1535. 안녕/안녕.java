import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] costs;
    private static int[] values;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        costs = new int[N + 1];
        values = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][101];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 100; j++) {
                if (j <= costs[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costs[i]] + values[i]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }
}
