import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][N + 1];
        int[] rows = new int[N + 1];
        int[] cols = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            rows[i] = r;
            cols[i] = c;
        }

        for (int dist = 1; dist < N; dist++) {
            for (int start = 1; start <= N; start++) {
                int end = start + dist;
                if (end > N) break;
                dp[start][end] = Integer.MAX_VALUE;
                for (int mid = start; mid < end; mid++) {
                    dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid + 1][end] +
                            rows[start] * cols[mid] * cols[end]);
                }

            }
        }

        System.out.println(dp[1][N]);
    }
}
