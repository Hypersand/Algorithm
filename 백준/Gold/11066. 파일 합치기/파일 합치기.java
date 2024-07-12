import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[K + 1];
            int[] sum = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];
            for (int j = 1; j <= K; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum[j] = sum[j - 1] + arr[j];
            }

            for (int dist = 1; dist < K; dist++) {
                for (int start = 1; start + dist <= K; start++) {
                    dp[start][start + dist] = INF;
                    for (int mid = start; mid < start + dist; mid++) {
                        dp[start][start + dist] = Math.min(dp[start][mid] + dp[mid + 1][start + dist] + sum[start + dist] - sum[start - 1],
                                dp[start][start + dist]);
                    }
                }
            }

            System.out.println(dp[1][K]);


        }
    }
}
