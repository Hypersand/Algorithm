import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr1 = br.readLine().split("");
        String[] arr2 = br.readLine().split("");
        String[] arr3 = br.readLine().split("");

        int[][][] dp = new int[arr1.length + 1][arr2.length + 1][arr3.length + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                for (int k = 1; k < dp[i][j].length; k++) {
                    if (arr1[i - 1].equals(arr2[j - 1]) && arr1[i - 1].equals(arr3[k - 1])) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                        continue;
                    }

                    dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                }
            }
        }

        System.out.println(dp[arr1.length][arr2.length][arr3.length]);
    }
}
