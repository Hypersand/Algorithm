
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long tmp = 1000000000;
        long answer = 0;

        long [][] dp = new long [N+1][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i<=N; i++) {
            for (int j = 0; j < 10; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j+1] % tmp;
                }
                else if (j == 9) {
                    dp[i][j] = dp[i-1][j-1] % tmp;
                }
                else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % tmp;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            answer += dp[N][i];
        }

        System.out.println(answer%tmp);

    }

}
