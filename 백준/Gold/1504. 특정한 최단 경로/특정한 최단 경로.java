import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int INF = 100000000;
    private static List<Node>[] lists;
    private static int[] dp;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        int E = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            lists[u].add(new Node(v, cost));
            lists[v].add(new Node(u, cost));
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
        dp = new int[N + 1];
        Arrays.fill(dp, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.cost - n2.cost;
            }
        });
        pq.add(new Node(start, 0));
        dp[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (Node next : lists[node.num]) {
                if (dp[next.num] > dp[node.num] + next.cost) {
                    dp[next.num] = dp[node.num] + next.cost;
                    pq.add(next);
                }
            }
        }
        return dp[end];
    }

    private static class Node {
        private int num;
        private int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
}
