import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] L = new int[N];

        st = new StringTokenizer(br.readLine());

        int max = 0;

        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, L[i]);
        }

        if (M > N) {
            long cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += L[i];
            }

            if (cnt < M) {
                System.out.println(0);
                return;
            }
        }

        int start = 1;
        int end = max;

        while (start <= end) {
            int mid = (start + end) / 2;

            long cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += L[i] / mid;
            }

            // 막대과자를 너무 많이 쪼갠 경우 -> 길이를 더 늘린다.
            if (cnt >= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}
