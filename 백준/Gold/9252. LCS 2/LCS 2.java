import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1Arr = br.readLine().split("");
        String[] str2Arr = br.readLine().split("");

        int[][] dp = new int[1001][1001];
        for (int i = 0; i < str1Arr.length; i++) {
            for (int j = 0; j < str2Arr.length; j++) {
                if (str1Arr[i].equals(str2Arr[j])) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    continue;
                }

                dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }

        int cnt = dp[str1Arr.length][str2Arr.length];
        if (cnt == 0) {
            System.out.println(0);
            return;
        }
        int x = str1Arr.length;
        int y = str2Arr.length;

        String str = "";
        while(x!=0 && y!=0) {
            if(str1Arr[x-1].equals(str2Arr[y-1])) {
                str += str1Arr[x-1];
                x--;
                y--;
            } else if(dp[x-1][y] == dp[x][y]) {
                x--;
            } else{
                y--;
            }
        }

        String ans = "";
        for(int i=str.length()-1; i>=0; i--) {
            ans += str.charAt(i);
        }

        System.out.println(cnt);
        System.out.println(ans);


    }
}
