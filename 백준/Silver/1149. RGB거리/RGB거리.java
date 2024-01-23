import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[3][N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
            arr[2][i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[3][N+1];
        for (int i = 1; i <= N; i++) {
            dp[0][i] = Math.min(dp[1][i - 1], dp[2][i - 1]) + arr[0][i];
            dp[1][i] = Math.min(dp[0][i - 1], dp[2][i - 1]) + arr[1][i];
            dp[2][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + arr[2][i];
        }

        int min = Math.min(dp[0][N], Math.min(dp[1][N], dp[2][N]));
        System.out.println(min);
    }
}
