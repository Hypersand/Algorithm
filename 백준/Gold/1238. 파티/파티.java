import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int INF = 100000000;
    private static int X;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        List<Node>[] lists = new List[N + 1];
        List<Node>[] reverseLists = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
            reverseLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            lists[start].add(new Node(end, cost));
            reverseLists[end].add(new Node(start, cost));
        }

        int[] dist = dijkstra(lists);
        int[] reverseDist = dijkstra(reverseLists);
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(dist[i] + reverseDist[i], max);
        }

        System.out.println(max);
    }


    private static int[] dijkstra(List<Node>[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[X] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            for (Node nextNode : lists[curNode.end]) {
                if (dist[nextNode.end] > dist[curNode.end] + nextNode.cost) {
                    dist[nextNode.end] = dist[curNode.end] + nextNode.cost;
                    pq.add(new Node(nextNode.end, dist[nextNode.end]));
                }
            }
        }

        return dist;
    }

    private static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
