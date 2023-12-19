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
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 2];
        arr[0] = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[N + 1] = L;
        Arrays.sort(arr);

        int start = 1;
        int end = L - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            for (int i = 1; i < arr.length; i++) {
                int length = arr[i] - arr[i - 1];
                cnt += (length - 1) / mid;
            }

            if (cnt > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
