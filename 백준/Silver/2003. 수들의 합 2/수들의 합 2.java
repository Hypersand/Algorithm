
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int sum = arr[i];
            if (i == N - 1) {
                if (sum == M) {
                    count++;
                }
                break;
            }
            if (sum == M) {
                count++;
                continue;
            }
            for (int j = i + 1; j < N; j++) {
                sum += arr[j];
                if (sum == M) {
                    count++;
                    break;
                }
                else if (sum > M) {
                    break;
                }
            }
        }

        System.out.println(count);

    }
}
