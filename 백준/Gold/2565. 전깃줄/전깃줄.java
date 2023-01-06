

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int [] arr;
    private static int [] dp;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[501];
        dp = new int[501];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            max = Math.max(max, a);
            arr[a] = b;
        }

        count();
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            ans = Math.max(ans,dp[i]);
        }
        System.out.println(N-ans);

    }


    private static void count() {

        for (int i = 1; i <= max; i++) {
            if(arr[i]==0) continue;
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if(arr[j]==0) continue;
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
    }

}
