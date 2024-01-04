import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        comb(0, 0);
        System.out.println(sb);
    }

    private static void comb(int idx, int num) {
        if (idx == N) {
            sb.append(num).append("\n");
            return;
        }

        for (int i = 1; i <= 9; i++) {
            int newNum = num * 10 + i;
            if (newNum == 1) continue;
            if (isPrime(newNum)) {
                comb(idx + 1, newNum);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num > 10) {
            if (num % 10 == 2 || num % 10 == 5) {
                return false;
            }
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
