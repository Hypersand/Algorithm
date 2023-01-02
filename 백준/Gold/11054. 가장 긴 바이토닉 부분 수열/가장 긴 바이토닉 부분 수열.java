
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int [] arr;
    private static int [] r_dp;
    private static int [] l_dp;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        r_dp = new int[N];
        l_dp = new int[N];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp1();
        dp2();

        max = r_dp[0] + l_dp[0] - 1;
        for (int i = 1; i < N; i++) {
            if (r_dp[i] + l_dp[i] - 1 > max) {
                max = r_dp[i] + l_dp[i] - 1;
            }
        }

        System.out.println(max);
    }

    private static void dp1() {
        for (int i = 0; i < N; i++) {
            r_dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && r_dp[j] + 1 > r_dp[i]) {
                    r_dp[i] = r_dp[j] + 1;
                }
            }
        }
    }

    private static void dp2() {
        for (int i = N-1; i >=0;  i--) {
            l_dp[i] = 1;
            for (int j = N-1; j > i; j--) {
                if (arr[i] > arr[j] && l_dp[j] + 1 > l_dp[i]) {
                    l_dp[i] = l_dp[j] + 1;
                }
            }
        }
    }
}
