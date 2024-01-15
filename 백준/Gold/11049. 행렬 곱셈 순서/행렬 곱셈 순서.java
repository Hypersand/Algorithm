import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][N + 1];
        int[][] arr = new int[N + 1][3]; //1행 1열 : 첫번째 행렬의 행, 1행 2열 : 첫번쨰 행렬의 열
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][1] = r;
            arr[i][2] = c;
        }

        for (int dist = 1; dist < N; dist++) {
            for (int start = 1; start + dist <= N; start++) {
                int end = start + dist;
                dp[start][end] = INF;
                for (int mid = start; mid < end; mid++) {
                    dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid + 1][end] + arr[start][1] * arr[mid][2] * arr[end][2]);
                }
            }
        }

        System.out.println(dp[1][N]);
    }
}
