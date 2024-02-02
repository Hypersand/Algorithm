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
        int[][] sum = new int[N + 1][M + 1];
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                sum[i][j] = Integer.parseInt(st.nextToken()) + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                answer = Math.max(answer, sum[i][j]);
            }
        }

        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= M; col++) {
                for (int i = 1; i <= row; i++) {
                    for (int j = 1; j <= col; j++) {
                        int tmpSum = sum[row][col] - (sum[row - i][col] + sum[row][col - j]) + sum[row - i][col - j];
                        answer = Math.max(answer, tmpSum);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
