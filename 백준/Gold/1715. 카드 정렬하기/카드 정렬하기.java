import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        if (N == 1) {
            System.out.println(0);
            return;
        }
        if (N == 2) {
            System.out.println(pq.poll() + pq.poll());
            return;
        }
        int ans = 0;
        while (pq.size() > 1) {
            int tmp1 = pq.poll();
            int tmp2 = pq.poll();
            int sum = tmp1 + tmp2;
            ans += sum;
            pq.add(sum);
        }

        System.out.println(ans);
    }
}
