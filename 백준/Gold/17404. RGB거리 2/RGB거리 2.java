import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][4];
        int[][] dp = new int[N + 1][4];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = INF;
        for (int start = 1; start <= 3; start++) {
            for (int i = 1; i <= 3; i++) {
                if (i == start) {
                    dp[1][start] = arr[1][start]; // 첫번째 칸을 start번째 색으로 칠하고 시작
                } else {
                    dp[1][i] = INF; // 색칠하지 않은 칸은 INF로 채우기
                }
            }

            for (int i = 2; i <= N; i++) {
                dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][3]) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][3]) + arr[i][2];
                dp[i][3] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][3];
            }

            for (int i = 1; i <= 3; i++) {
                if (i == start) continue;
                answer = Math.min(answer, dp[N][i]);
            }
        }

        System.out.println(answer);
    }
}
