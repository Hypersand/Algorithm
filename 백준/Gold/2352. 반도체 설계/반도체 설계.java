import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];
        int maxLength = 1;

        for (int i = 2; i <= n; i++) {
            // 현재 숫자가 리스트의 몇번째 인덱스에 들어갈 수 있는지 탐색한다.
            if (dp[maxLength] < arr[i]) {
                maxLength++;
                dp[maxLength] = arr[i];
                continue;
            }
            int start = 1;
            int end = maxLength;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (dp[mid] < arr[i]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            dp[start] = arr[i];

        }

        System.out.println(maxLength);
    }
}
