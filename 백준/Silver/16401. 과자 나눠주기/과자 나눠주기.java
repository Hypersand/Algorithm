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
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int minLength = 1;
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            int length = Integer.parseInt(st.nextToken());
            maxLength = Math.max(length, maxLength);
            arr[i] = length;
        }

        int cnt = 0;
        int mid = 0;
        while (minLength <= maxLength) {
            cnt = 0;
            mid = (minLength + maxLength) / 2;
            for (int i = 0; i < N; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt < M) {
                maxLength = mid - 1;
            } else {
                minLength = mid + 1;
            }
        }

        System.out.println(maxLength);

    }
}
