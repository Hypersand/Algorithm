import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            dp[num] = dp[num - 1] + 1;
            maxLength = Math.max(dp[num], maxLength);
        }
        System.out.println(N - maxLength);


    }
}
