import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] snake = new int[101];
    private static int[] ladder = new int[101];
    private static int[] dp = new int[101]; // 해당 지점에 도달하는데 걸린 횟수 기록
    private static final int INF = 100000000;
    public static void main(String[] args) throws IOException {
        Arrays.fill(dp, INF);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladder[x] = y;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            snake[u] = v;
        }

        game(1, 0);
        System.out.println(dp[100]);
    }

    private static void game(int idx, int cnt) {
        if (idx > 100) return;
        if (dp[idx] <= cnt) return;

        dp[idx] = cnt;

        for (int i = 1; i <= 6; i++) {
            // 사다리가 있는 경우
            if (idx + i <= 100 && ladder[idx + i] != 0) {
                game(ladder[idx + i], cnt + 1);
                continue;
            }

            // 뱀이 있는 경우
            if (idx + i <= 100 && snake[idx + i] != 0) {
                game(snake[idx + i], cnt + 1);
                continue;
            }

            game(idx + i, cnt + 1);
        }
    }
}
