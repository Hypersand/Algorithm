import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node(num, start, end));
        }

        Collections.sort(list, (Node n1, Node n2) -> n1.start- n2.start);
        int answer = 1;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (pq.isEmpty()) {
                pq.add(list.get(i));
                continue;
            }

            if (pq.peek().end <= list.get(i).start) {
                pq.poll();
            }
            pq.add(list.get(i));
            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);
    }

    private static class Node implements Comparable<Node> {
        private int idx;
        private int start;
        private int end;

        public Node(int idx, int start, int end) {
            this.idx = idx;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node n) {
            if (this.end == n.end) {
                return this.start - n.start;
            }
            return this.end - n.end;
        }
    }
}
