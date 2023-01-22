
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            long[] dp = new long[101];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;
            int N = Integer.parseInt(br.readLine());
            for (int j = 5; j <= N; j++) {
                dp[j] = dp[j - 1] + dp[j - 5];
            }
            sb.append(dp[N]+"\n");
        }

        System.out.println(sb);
    }
}
