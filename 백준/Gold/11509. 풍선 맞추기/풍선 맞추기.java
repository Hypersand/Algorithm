import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1000001];

        int cnt = 1;
        dp[arr[1]]++;
        for (int i = 2; i <= N; i++) {
            if (dp[arr[i] + 1] > 0) {
                dp[arr[i] + 1]--;
                dp[arr[i]]++;
            } else {
                cnt++;
                dp[arr[i]]++;
            }
        }

        System.out.println(cnt);
    }
}
