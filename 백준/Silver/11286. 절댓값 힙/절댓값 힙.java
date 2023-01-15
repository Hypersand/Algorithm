
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.abs == o2.abs) {
                    return o1.origin - o2.origin;
                }
                return o1.abs - o2.abs;
            }
        });


        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (queue.isEmpty()) {
                    sb.append("0" + "\n");
                }
                else {
                    Node n = queue.poll();
                    sb.append(n.origin+"\n");
                }
            }
            else {
                queue.add(new Node(x, Math.abs(x)));
            }

        }

        System.out.println(sb);
    }
    
    private static class Node{
        int origin;
        int abs;

        public Node(int origin, int abs) {
            this.origin = origin;
            this.abs = abs;
        }
    }
}
