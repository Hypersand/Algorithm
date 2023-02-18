
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        int MAX = (int) Math.pow(2, 31);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>();

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            queue.add(arr[i]);
        }

        long prime = 0;

        while (N != 0) {

            prime = queue.poll();

            for (int i = 0; i < K; i++) {
                if (prime * arr[i] >= MAX) {
                    break;
                }
                queue.add(prime * arr[i]);

                if (prime % arr[i] == 0) {
                    break;
                }
            }
            N--;
        }

        System.out.println(prime);
    }
}
