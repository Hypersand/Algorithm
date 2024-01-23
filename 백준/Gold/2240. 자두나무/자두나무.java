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
        int[] orders = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            orders[i] = Integer.parseInt(br.readLine());
        }
        int max = W;
        int[][][] dp = new int[T + 1][3][W + 2];
        for (int i = 1; i <= T; i++) {
            for (int k = 1; k <= W + 1; k++) {
                if (orders[i] == 1) {
                    dp[i][1][k] = Math.max(dp[i - 1][1][k], dp[i - 1][2][k - 1]) + 1;
                    dp[i][2][k] = Math.max(dp[i - 1][2][k], dp[i - 1][1][k - 1]);
                } else {
                    if (i == 1 && k == 1) continue; // 무조건 1번 위치에서 시작하기 때문에, i가 1일 때, k가 1일 수 없다.
                    dp[i][1][k] = Math.max(dp[i - 1][1][k], dp[i - 1][2][k - 1]);
                    dp[i][2][k] = Math.max(dp[i - 1][2][k], dp[i - 1][1][k - 1]) + 1;
                }
                max = Math.max(max, Math.max(dp[i][1][k], dp[i][2][k]));
            }
        }

        System.out.println(max);
    }
}
