import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + k - 1];
        int[] cnt = new int[d + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N; i < N + k - 1; i++) {
            arr[i] = arr[i % N];
        }

        int max = 0;
        for (int i = 0; i < k; i++) {
            if (cnt[arr[i]] == 0) max++;
            cnt[arr[i]]++;
        }

        int answer = 0;
        if (cnt[c] == 0) {
            answer = Math.max(max + 1, answer);
        } else {
            answer = Math.max(max, answer);
        }

        for (int i = 0; i < N - 1; i++) {
            if (cnt[arr[i]]-- < 2) {
                max--;
            }
            if (cnt[arr[i + k]]++ == 0) {
                max++;
            }

            if (cnt[c] == 0) {
                answer = Math.max(max + 1, answer);
            } else {
                answer = Math.max(max, answer);
            }

        }

        System.out.println(answer);
    }
}
