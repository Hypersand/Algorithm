import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        int length = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j <= N; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    length = Math.max(length, dp[i]);
                }
            }
        }

        int answer = length;
        Stack<Integer> stack = new Stack<>();
        for (int i = N; i > 0; i--) {
            if (dp[i] == length) {
                stack.push(arr[i]);
                length--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(answer);
        System.out.println(sb);
    }
}
