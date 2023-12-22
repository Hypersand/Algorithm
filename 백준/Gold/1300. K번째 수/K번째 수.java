import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        long K = Integer.parseInt(br.readLine());
        long start = 1;
        long end = K;
        while (start <= end) {
            long mid = (start + end) / 2;
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                long num = mid / i;
                if (num > N) num = N;
                cnt += num;
            }
            if (cnt >= K) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
    }
}
