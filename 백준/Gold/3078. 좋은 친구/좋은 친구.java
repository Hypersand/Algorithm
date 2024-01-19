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
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] lens = new int[21];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().length();
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= K; i++) {
            queue.add(arr[i]);
            lens[arr[i]]++;
        }

        long answer = 0;
        int idx = K + 1;
        while (!queue.isEmpty()) {
            int length = queue.poll();
            lens[length]--;
            answer += lens[length];
            if (idx < N) {
                queue.add(arr[idx]);
                lens[arr[idx++]]++;
            }
        }
        System.out.println(answer);
    }
}
