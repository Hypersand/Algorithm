import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static List<Node>[] lists;
    private static int[] dists;
    private static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dists = new int[N + 1];
        Arrays.fill(dists, INF);
        lists = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[a].add(new Node(b, c));
            lists[b].add(new Node(a, c));
        }

        find();
        System.out.println(dists[N]);
    }

    private static void find() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dists[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node next : lists[cur.idx]) {
                if (dists[next.idx] > dists[cur.idx] + next.dist) {
                    dists[next.idx] = dists[cur.idx] + next.dist;
                    pq.add(new Node(next.idx, next.dist));
                }
            }
        }

    }

    private static class Node implements Comparable<Node> {
        private int idx;
        private int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node node) {
            return this.dist - node.dist;
        }
    }
}
