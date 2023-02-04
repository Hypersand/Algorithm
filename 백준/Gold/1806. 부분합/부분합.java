
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] += arr[i-1] + Integer.parseInt(st.nextToken());
        }

        int minLength = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                if (arr[i] >= S) {
                    System.out.println(1);
                    return;
                }
            }

            if (arr[i] >= S) {
                minLength = Math.min(minLength, i);
            }

            for (int j = i - 1; j > 0; j--) {
                if (arr[i] - arr[j] >= S) {
                    minLength = Math.min(minLength, i - j);
                    break;
                }
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else {
            System.out.println(minLength);
        }
    }
}
