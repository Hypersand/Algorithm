
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int[] lens = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        Arrays.fill(lens, 1);
        int length = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] > dp[length - 1]) {
                dp[length] = arr[i];
                lens[i] = ++length;
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
            lens[i] = (start + 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(length).append("\n");
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (lens[i] == length) {
                stack.push(arr[i]);
                length--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
