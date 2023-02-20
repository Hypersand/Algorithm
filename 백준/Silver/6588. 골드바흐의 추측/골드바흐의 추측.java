
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] isPrime = new boolean[1000000];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < Math.sqrt(1000000); i++) {
            for (int j = i * 2; j < 1000000; j += i) {
                isPrime[j] = false;
            }
        }


        String str = "";
        while (!(str = br.readLine()).equals("0")) {
            int n = Integer.parseInt(str);
            int count = 0;
            for (int i = 3; i <= n / 2; i+=2) {
                if (isPrime[i] && isPrime[n - i]) {
                    sb.append(n + " = " + i + " + " + (n - i)).append("\n");
                    count++;
                    break;
                }
            }

            if (count == 0) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }

        System.out.println(sb);

    }
}
