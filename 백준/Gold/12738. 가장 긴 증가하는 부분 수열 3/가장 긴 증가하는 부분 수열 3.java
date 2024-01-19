import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int length = 1;
        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] > dp[length - 1]) {
                dp[length++] = arr[i];
                continue;
            }

            int start = 0;
            int end = length;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (dp[mid] >= arr[i]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            dp[start] = arr[i];
        }

        System.out.println(length);
    }
}
