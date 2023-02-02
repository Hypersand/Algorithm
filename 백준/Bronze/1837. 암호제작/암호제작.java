
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] P = st.nextToken().toCharArray();
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= 1000000; i++) {
            if (isPrime[i]) {
                list.add(i);
                if (i <= Math.sqrt(1000000)) {
                    for (int j = i * i; j <= 1000000; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }

        for (Integer prime : list) {
            if (prime >= K) {
                break;
            }
            int sum = 0;
            for (int i = 0; i < P.length; i++) {
                sum = (sum * 10 + P[i] - '0') % prime;
            }
            if (sum == 0) {
                System.out.println("BAD " + prime);
                return;
            }

        }
        System.out.println("GOOD");
    }

}
