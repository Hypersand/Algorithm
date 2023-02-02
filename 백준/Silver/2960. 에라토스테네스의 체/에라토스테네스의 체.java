
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
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                if (isPrime[j]) {
                    isPrime[j] = false;
                    count++;
                }
                if (K == count) {
                    System.out.println(j);
                    System.exit(0);
                }
            }

        }

    }
}
