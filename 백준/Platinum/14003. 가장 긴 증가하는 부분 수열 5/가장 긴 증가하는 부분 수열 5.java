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
        int[] mem = new int[N + 1];
        int lis = 1;
        dp[lis] = arr[1];
        mem[1] = 1;
        for (int i = 2; i <= N; i++) {
            if (arr[i] > dp[lis]) {
                dp[++lis] = arr[i];
                mem[i] = lis;
            } else {
                int start = 1;
                int end = lis;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (arr[i] <= dp[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
                dp[start] = arr[i];
                mem[i] = start;
            }
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int length = lis;
        for (int i = N; i >= 1; i--) {
            if (length == 0) break;
            if (mem[i] == length) {
                stack.push(arr[i]);
                length--;
            }
        }

        sb.append(lis).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);

    }
}
