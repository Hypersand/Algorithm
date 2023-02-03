
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    private static long[][] dp;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new long[N + M + 1][N + M + 1];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                if (dp[i][j]>1000000000) {
                    dp[i][j] = 1000000000;
                }
            }
        }

        if (dp[N + M][N] < K) {
            System.out.println(-1);
            return;
        }

        search(K, N, M);
        System.out.println(sb);
    }

    private static void search(int K, int N, int M) {

        if (K <= 0) {
            return;
        }

        if (N == 0 && M >0) {
            while (M != 0) {
                sb.append("z");
                M--;
            }
            return;
        }

        if (M == 0 && N >0) {
            while (N != 0) {
                sb.append("a");
                N--;
            }
            return;
        }

        if (N == 0 && M == 0) {
            return;
        }

        if (dp[N + M - 1][N - 1] < K) {
            sb.append("z");
            search(K - (int)dp[N + M - 1][N - 1], N, M - 1);
        }
        else {
            sb.append("a");
            search(K, N-1, M);
        }

    }


}
