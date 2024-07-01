import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        if (sum % 3 != 0) {
            System.out.println("NO");
            return;
        }

        sum /= 3; // 1과 2의 쌍의 최대 개수
        int twoCnt = 0;
        for (int i = 0; i < N; i++) {
            twoCnt += arr[i] / 2;
        }

        if (twoCnt < sum) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }
}
