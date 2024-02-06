import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] cities = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cities[i][0] = Integer.parseInt(st.nextToken()); //비용
            cities[i][1] = Integer.parseInt(st.nextToken()); //고객의 수
        }
        int[] dp = new int[C + 101];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            int cost = cities[i][0];
            int people = cities[i][1];
            for (int j = people; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], cost + dp[j - people]);
            }
        }

        int answer = INF;
        for (int i = C; i < dp.length; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
