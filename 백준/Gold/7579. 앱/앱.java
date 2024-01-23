import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] mems = new int[N + 1];
        int[] costs = new int[N + 1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 1; i <= N; i++) {
            mems[i] = Integer.parseInt(st1.nextToken());
            costs[i] = Integer.parseInt(st2.nextToken());
            max += costs[i];
        }

        int[][] dp = new int[N + 1][max + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= max; j++) {
                if (costs[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costs[i]] + mems[i]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= max; j++) {
                if (dp[i][j] >= M) {
                    answer = Math.min(answer, j);
                }
            }
        }
        System.out.println(answer);
    }
}
