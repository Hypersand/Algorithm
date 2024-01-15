import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            int[] arr = new int[K+1];
            int[][] dp = new int[K+1][K+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= K; j++) {
                arr[j] = Integer.parseInt(st.nextToken()) + arr[j-1];
            }

            for (int dist = 1; dist < K; dist++) {
                for (int start = 1; start + dist <= K; start++) {
                    int end = start + dist;
                    dp[start][end] = Integer.MAX_VALUE;
                    for (int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid + 1][end]);
                    }
                    dp[start][end] += arr[end] - arr[start - 1];

                }
            }
            System.out.println(dp[1][K]);
        }
    }
}
