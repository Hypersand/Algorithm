import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] sums = new int[H + 1];
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            // 석순
            if (i % 2 == 0) {
                sums[0]++;
                sums[height]--;
                continue;
            }
            // 종유석
            sums[H - height]++;
            sums[H]--;
        }

        int min = sums[0];
        int count = 1;

        for (int i = 1; i < sums.length - 1; i++) {
            sums[i] += sums[i - 1];
            if (sums[i] < min) {
                min = sums[i];
                count = 1;
            } else if (sums[i] == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}
