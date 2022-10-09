

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[1000001];
        int [] num = new int[3];
        dp[1] = 0;
        dp[2] = dp[3] = 1;
        if(N>=4) {
            for (int i = 4; i <= N; i++) {
                num[0] = num[1] = num[2] = Integer.MAX_VALUE;
                if (i % 3 == 0) {
                    num[0] = Math.min(dp[i / 3], dp[i - 1]) + 1;
                }
                if (i % 2 == 0) {
                    num[1] = Math.min(dp[i / 2], dp[i - 1]) + 1;

                }
                    num[2]= dp[i - 1] + 1;
                Arrays.sort(num);
                dp[i] = num[0];
            }
        }
        System.out.println(dp[N]);



    }
    }


