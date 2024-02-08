import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] times;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        times = new int[N];
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(times);
        long start = times[0];
        long end = (long) times[times.length - 1] * M;
        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for (int time : times) {
                cnt += mid / time;
                if (cnt >= M) break;
            }

            if (cnt >= M) {
                end = mid - 1;
                continue;
            }

            start = mid + 1;
        }
        System.out.println(start);
    }
}
