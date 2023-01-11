
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static long T = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());

        long answer = ((factorial(N) % T) * (DAC((factorial(K) * factorial(N - K)), T - 2) % T)) % T;

        System.out.println(answer);
    }

    private static long factorial(long number) {
        if (number <= 1) {
            return 1;
        }
        return (number * factorial(number - 1)) % T;
    }

    private static long DAC(long number, long exp) {
        if (exp == 0) {
            return 1;
        }
        else if (exp == 1) {
            return number % T;
        }
        else {
            long tmp = DAC(number, exp / 2);
            if (exp % 2 == 0) {
                return (tmp * tmp) % T;
            }
            else {
                return (tmp*((tmp*(number%T))%T))%T;
            }

        }
    }

}

