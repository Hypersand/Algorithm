import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        int max = 0;
        int cnt = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i < X) {
                max += arr[i];
            }
        }

        int sum = max;

        for (int i = 1; i < N-1; i++) {
            if (N - i < X) {
                break;
            }

            int tmp = sum - arr[i - 1] + arr[i + X - 1];
            if (tmp == max) {
                cnt++;
            } else if (tmp > max) {
                max = tmp;
                cnt = 1;
            }
            sum = tmp;
        }

        StringBuilder sb = new StringBuilder();

        if (max == 0) {
            sb.append("SAD");
        } else {
            sb.append(max).append("\n");
            sb.append(cnt);
        }

        System.out.println(sb);
    }
}
