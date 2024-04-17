import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static boolean[] holiday;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        holiday = new boolean[N + 1];
        
        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int day = Integer.parseInt(st.nextToken());
                holiday[day] = true;
            }
        }

        dp = new int[N + 1][45];

        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(find(1, 0));
    }

    private static int find(int day, int coupon) {
        if (day > N) return 0;
        if (dp[day][coupon] != -1) return dp[day][coupon];

        dp[day][coupon] = Integer.MAX_VALUE;

        if (holiday[day]) {
            return dp[day][coupon] = Math.min(dp[day][coupon], find(day + 1, coupon));
        }

        if (coupon >= 3) {
            dp[day][coupon] = Math.min(dp[day][coupon], find(day + 1, coupon - 3));
        }

        dp[day][coupon] = Math.min(dp[day][coupon], find(day + 1, coupon) + 10000);
        dp[day][coupon] = Math.min(dp[day][coupon], find(day + 3, coupon + 1) + 25000);
        dp[day][coupon] = Math.min(dp[day][coupon], find(day + 5, coupon + 2) + 37000);

        return dp[day][coupon];
    }
}
