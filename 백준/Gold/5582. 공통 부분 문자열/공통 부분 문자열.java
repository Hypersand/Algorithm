import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        char[] arr1 = new char[str1.length() + 1];
        char[] arr2 = new char[str2.length() + 1];

        for (int i = 1; i < arr1.length; i++) {
            arr1[i] = str1.charAt(i - 1);
        }

        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = str2.charAt(i - 1);
        }

        int[][] dp = new int[arr1.length][arr2.length];
        int maxLength = 0;

        for (int i = 1; i < arr1.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    if (arr1[i - 1] != arr2[j - 1] || dp[i-1][j-1] == 0) {
                        dp[i][j] = 1;
                    }

                    if (arr1[i - 1] == arr2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }

                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        System.out.println(maxLength);
    }
}
