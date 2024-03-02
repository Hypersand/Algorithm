import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger top = BigInteger.valueOf(1);
        BigInteger bottom = BigInteger.valueOf(1);

        for (int i = n; i > n - m; i--) {
            BigInteger num = BigInteger.valueOf(i);
            top = top.multiply(num);
        }

        for (int i = m; i >= 1; i--) {
            BigInteger num = BigInteger.valueOf(i);
            bottom = bottom.multiply(num);
        }

        System.out.println(top.divide(bottom));
    }
}
