import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int INF = 100000000;
        int[][] arr = new int[N + 1][4];
        int[][] dp = new int[N + 1][4];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = INF;
        for (int start = 1; start <= 3; start++) {
            for (int i = 1; i <= 3; i++) {
                if (i == start) {
                    dp[1][i] = arr[1][i];
                } else {
                    dp[1][i] = INF;
                }
            }

            for (int i = 2; i <= N; i++) {
                dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][3]) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][3]) + arr[i][2];
                dp[i][3] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][3];
            }

            if (start == 1) {
                dp[N][1] = INF;
            } else if (start == 2) {
                dp[N][2] = INF;
            } else {
                dp[N][3] = INF;
            }

            for (int i = 1; i <= 3; i++) {
                answer = Math.min(dp[N][i], answer);
            }
        }

        System.out.println(answer);
    }
}
