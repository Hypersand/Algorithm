import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static List<Node>[] lists;
    private static final int INF = 200000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[a].add(new Node(b, c));
            lists[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int cost1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int cost2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
        if (cost1 >= INF && cost2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(cost1, cost2));
        }
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        int[] dists = new int[N+1];
        Arrays.fill(dists, INF);
        dists[start] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node next : lists[node.idx]) {
                if (dists[next.idx] > dists[node.idx] + next.cost) {
                    dists[next.idx] = dists[node.idx] + next.cost;
                    queue.add(new Node(next.idx, dists[next.idx]));
                }
            }
        }

        return dists[end];
    }

    private static class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
