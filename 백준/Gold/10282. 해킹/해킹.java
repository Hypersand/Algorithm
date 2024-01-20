import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Node>[] lists;
    private static final int INF = 200000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                lists[j] = new ArrayList<>();
            }
            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                lists[b].add(new Node(a, s));
            }
            sb.append(dijkstra(c)).append("\n");
        }
        System.out.println(sb);
    }

    private static String dijkstra(int start) {
        int[] dist = new int[lists.length];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node next : lists[node.idx]) {
                if (dist[next.idx] > dist[node.idx] + next.cost) {
                    int seconds = dist[node.idx] + next.cost;
                    dist[next.idx] = seconds;
                    queue.add(new Node(next.idx, seconds));
                }
            }
        }

        int maxSeconds = 0;
        int visitedCnt = 0;
        for (int i = 1; i < lists.length; i++) {
            if (dist[i] != INF) {
                visitedCnt++;
                maxSeconds = Math.max(maxSeconds, dist[i]);
            }
        }
        return visitedCnt + " " + maxSeconds;
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
