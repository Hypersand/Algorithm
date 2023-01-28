
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N + 1][K + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (j == 1) {
                    dp[i][j] = 1;
                }
                else {
                    for (int k = 0; k <= i; k++) {
                        dp[i][j] += dp[k][j - 1]%1000000000;
                    }
                    dp[i][j] %= 1000000000;
                }
            }
        }
        System.out.println(dp[N][K]);

    }
}
