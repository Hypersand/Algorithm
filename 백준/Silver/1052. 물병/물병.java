import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K - 1; i++) {
            int tmp = 0;
            while (true) {
                if (Math.pow(2, tmp) > N) {
                    break;
                }
                tmp++;
            }

            N -= Math.pow(2, tmp - 1);

            if (N == 0) {
                System.out.println(0);
                return;
            }
        }

        int tmp = 0;
        while (true) {
            if (Math.pow(2, tmp) >= N) {
                System.out.println((int)Math.pow(2,tmp) - N);
                return;
            }
            tmp++;
        }
    }
}
