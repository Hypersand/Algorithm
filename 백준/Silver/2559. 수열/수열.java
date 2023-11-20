import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (start < N) {
            if (end - start < K) {
                sum += arr[end++];
            } else if (end >= N) {
                max = Math.max(sum, max);
                break;
            } else {
                max = Math.max(sum, max);
                sum -= arr[start++];
            }
        }

        System.out.println(max);
    }
}
