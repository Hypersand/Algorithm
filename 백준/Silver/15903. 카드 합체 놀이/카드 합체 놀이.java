import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        while (M > 0) {
            Arrays.sort(arr);
            long sum = 0;
            for (int i = 0; i < 2; i++) {
                sum += arr[i];
            }
            arr[0] = sum;
            arr[1] = sum;
            M--;
        }

        long answer = 0;
        for (long num : arr) {
            answer += num;
        }
        System.out.println(answer);
    }
}
