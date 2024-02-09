import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] sums = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sums[i] = sums[i - 1] + arr[i];
        }

        int answer = 0;
        for (int i = 2; i < N; i++) {
            int sum1 = (sums[N] - sums[1]) + (sums[N] - sums[i]) - arr[i];
            int sum2 = (sums[i] - sums[1]) + (sums[N] - sums[i - 1]) - arr[N];
            int sum3 = (sums[N] - arr[N]) + (sums[i] - arr[i]) - arr[i];
            answer = Math.max(Math.max(sum1, Math.max(sum2, sum3)), answer);
        }

        System.out.println(answer);
    }
}
