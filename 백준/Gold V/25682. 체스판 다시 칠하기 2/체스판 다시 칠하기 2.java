import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[][] arr = new String[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }

        int[][] startBlack = new int[N][M]; // 첫 칸을 검정으로 칠했을 때
        //i + j 의 합이 짝수이면 검정, 홀수이면 흰색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((i + j) % 2 == 0) {
                    if (arr[i][j].equals("W")) {
                        startBlack[i][j] = 1;
                    }
                    continue;
                }

                if (arr[i][j].equals("B")) {
                    startBlack[i][j] = 1;
                }
            }
        }

        int[][] sums = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + startBlack[i - 1][j - 1];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i + K - 1 <= N; i++) {
            for (int j = 1; j + K - 1 <= M; j++) {
                int tmp1 = sums[i + K - 1][j + K - 1] - sums[i + K - 1][j - 1] - sums[i - 1][j + K - 1] + sums[i - 1][j - 1];
                int tmp2 = K * K - tmp1;
                min = Math.min(min, Math.min(tmp1, tmp2));
            }
        }

        System.out.println(min);
    }
}
