import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = N - 1;
        int min = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                ans1 = arr[start];
                ans2 = arr[end];
            }
            if (sum >= 0) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}
