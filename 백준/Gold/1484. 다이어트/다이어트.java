import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double G = Double.parseDouble(br.readLine());
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int start = 1;
        int end = 2;
        while (start < end) {
            double result = (double)(start + end) * (end - start);
            if (result == G) {
                cnt++;
                sb.append(end).append("\n");
                start++;
                continue;
            }

            if (result > G) {
                start++;
                continue;
            }
            end++;
        }

        if (cnt == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }

    }
}
