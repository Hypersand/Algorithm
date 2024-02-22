import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        List<Edge> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (cost == 0) continue;
                list.add(new Edge(i, j, cost));
            }
        }

        Collections.sort(list, (Edge e1, Edge e2) -> e1.cost - e2.cost);
        long cost = 0;
        for (Edge edge : list) {
            if (find(edge.nodeA) != find(edge.nodeB)) {
                union(edge.nodeA, edge.nodeB);
                cost += edge.cost;
            }
        }

        System.out.println(cost);
    }

    private static int find(int node) {
        if (parents[node] == node) {
            return node;
        }
        return parents[node] = find(parents[node]);
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

    private static class Edge {
        private int nodeA;
        private int nodeB;
        private int cost;

        public Edge(int nodeA, int nodeB, int cost) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.cost = cost;
        }
    }

}
