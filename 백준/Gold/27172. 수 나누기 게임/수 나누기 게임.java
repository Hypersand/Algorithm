import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }
        int[] cards = new int[max + 1];
        int[] scores = new int[max + 1];
        for (int i = 0; i < N; i++) {
            cards[arr[i]]++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = arr[i] * 2; j <= max; j += arr[i]) {
                if (cards[j] == 1) {
                    scores[arr[i]]++;
                    scores[j]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(scores[arr[i]]).append(" ");
        }
        System.out.println(sb);
    }
}
