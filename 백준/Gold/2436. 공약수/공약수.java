import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static long N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken()); // 최대공약수
        M = Long.parseLong(st.nextToken()); // 최소공배수

        int startNum = (int)Math.sqrt(N * M);
        long NM = N * M;

        for (long i = startNum; i > 0; i--) {
            if (NM % i != 0) continue;
            long a = NM / i;
            if (validate(a, i)) {
                System.out.println(i + " " + a);
                return;
            }
        }
    }

    // a와 b의 최대공약수와 최소공배수를 구한다.
    private static boolean validate(long a, long b) {
        long x = a;
        long y = b;
        long GCD = 0;
        while (true) {
            if (x % y == 0) {
                GCD = y;
                break;
            }
            long tmp = y;
            y = x % y;
            x = tmp;
        }

        long LCM = (a * b) / GCD;

        if (GCD == N && LCM == M) {
            return true;
        }

        return false;
    }
}
