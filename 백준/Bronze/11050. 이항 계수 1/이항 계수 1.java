
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

        int[] arr = {N, M, N - M};

        for (int i = 0; i < 3; i++) {
            int ans = 1;
            for (int j = arr[i]; j > 1; j--) {
                ans *= j;
            }
            arr[i] = ans;
        }

        System.out.println(arr[0] / (arr[1] * arr[2]));
    }
}
