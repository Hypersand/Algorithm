import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] coins = new int[2][k + 1];
        for (int i = 1; i <= k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coins[0][i] = Integer.parseInt(st.nextToken()); //금액
            coins[1][i] = Integer.parseInt(st.nextToken()); //갯수
        }

        int[][] dp = new int[k + 1][T + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= k; i++) {
            int coin = coins[0][i];
            int cnt = coins[1][i];
            for (int j = 0; j <= T; j++) {
                for (int t = 0; t <= cnt; t++) {
                    int pos = j - (coin * t);
                    if (pos < 0) break;
                    dp[i][j] += dp[i - 1][pos];
                }
            }
        }

        System.out.println(dp[k][T]);
    }
}
