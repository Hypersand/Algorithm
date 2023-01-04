
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a != 0) {
                queue.add(a);
            }
            else {
                if(queue.isEmpty()) {
                    sb.append(0+"\n");
                }
                else {
                    sb.append(queue.poll()+"\n");

                }

            }
        }

        System.out.println(sb);
    }
}
