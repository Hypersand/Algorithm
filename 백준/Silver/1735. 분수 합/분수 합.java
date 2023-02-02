
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a1,a2;
        int b1,b2;
        StringTokenizer st = new StringTokenizer(br.readLine());
        a1 = Integer.parseInt(st.nextToken());
        b1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        a2 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());

        int sumA = a1 * b2 + b1 * a2;
        int sumB = b1 * b2;
        int div = gcd(sumA, sumB);

        sumA /= div;
        sumB /= div;
        System.out.println(sumA + " " + sumB);
        
    }

    private static int gcd(int a, int b) {
        if (b % a == 0) {
            return a;
        }
        return gcd(b % a, a);
    }

}
