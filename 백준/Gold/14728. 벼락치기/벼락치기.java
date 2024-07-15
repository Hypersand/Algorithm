import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] costs = new int[N + 1];
        int[] scores = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][T + 1];
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= T; j++) {
                if (j >= costs[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costs[i]] + scores[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }
}
