
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class Main {

    private static List<Node>[] list;
    private static int[] dist;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        list = new ArrayList[V+1];
        dist = new int[V+1];
        visited = new boolean[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));

        }

        dijkstra(start);

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(dist[i]);
            }
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost-o2.cost;
            }
        });
        pq.add(new Node(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (visited[now.v]) {
                continue;
            }
            
            visited[now.v] = true;
            
            for (Node next : list[now.v]) {
                if (!visited[next.v] && dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }


        }

    }

    private static class Node  {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }


    }
}
