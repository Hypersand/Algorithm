
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> left_queue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right_queue = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int mid = Integer.parseInt(br.readLine());
        sb.append(mid).append("\n");

        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > mid) {
                right_queue.add(num);
            }

            else {
                left_queue.add(num);
            }

            if (right_queue.size() - left_queue.size() > 1) {
                left_queue.add(mid);
                mid = right_queue.poll();
            }

            if (left_queue.size() - right_queue.size() > 0) {
                right_queue.add(mid);
                mid = left_queue.poll();
            }

            sb.append(mid).append("\n");
        }

        System.out.println(sb);

    }
}
