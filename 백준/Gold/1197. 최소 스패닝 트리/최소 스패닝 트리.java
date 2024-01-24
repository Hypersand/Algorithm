import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int[] parents;
    private static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        parents = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.add(new Edge(A, B, C));
        }
        System.out.println(kruskal());
    }

    private static int kruskal() {
        int answer = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (find(edge.A) != find(edge.B)) {
                union(edge.A, edge.B);
                answer += edge.cost;
            }
        }
        return answer;
    }

    private static void union(int A, int B) {
        int pA = find(A);
        int pB = find(B);
        if (pA > pB) {
            parents[pA] = pB;
        } else {
            parents[pB] = pA;
        }
    }

    private static int find(int A) {
        if (parents[A] == A) {
            return A;
        }

        return parents[A] = find(parents[A]);
    }
    
    private static class Edge implements Comparable<Edge> {
        private int A;
        private int B;
        private int cost;

        public Edge(int a, int b, int cost) {
            A = a;
            B = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
