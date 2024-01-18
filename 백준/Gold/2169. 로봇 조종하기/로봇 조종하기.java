import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][M+2];
        int[][] dp = new int[N+1][M+2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = arr[1][1];
        for (int i = 2; i <= M; i++) {
            dp[1][i] = dp[1][i - 1] + arr[1][i];
        }

        for (int i = 2; i <= N; i++) {
            int[][] tmp = new int[2][M+2];
            tmp[0][0] = dp[i - 1][1];
            tmp[1][M+1] = dp[i - 1][M];
            for (int j = 1; j <= M; j++) {
                tmp[0][j] = Math.max(dp[i - 1][j], tmp[0][j - 1]) + arr[i][j];
            }

            for (int j = M; j > 0; j--) {
                tmp[1][j] = Math.max(dp[i - 1][j], tmp[1][j + 1]) + arr[i][j];
            }

            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(tmp[0][j], tmp[1][j]);
            }

        }

        System.out.println(dp[N][M]);
    }

}
