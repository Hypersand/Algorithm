import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parents = new int[N];
        List<Star> stars = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars.add(new Star(x, y));
        }

        List<Edge> edges = new ArrayList<>();
        //두 별 간에 거리 비교
        for (int i = 0; i < stars.size() - 1; i++) {
            for (int j = i + 1; j < stars.size(); j++) {
                double dist = calculateDist(stars.get(i), stars.get(j));
                edges.add(new Edge(i, j, dist));
            }
        }

        Collections.sort(edges);
        double answer = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if (find(edge.A) != find(edge.B)) {
                answer += edge.dist;
                union(edge.A, edge.B);
            }
        }

        System.out.printf("%.2f", answer);
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

    private static double calculateDist(Star star1, Star star2) {
        return Math.sqrt(Math.pow(star1.x - star2.x, 2) + Math.pow(star1.y - star2.y, 2));
    }

    private static class Star {
        private double x;
        private double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Edge implements Comparable<Edge> {
        private int A;
        private int B;
        private double dist;

        public Edge(int a, int b, double dist) {
            A = a;
            B = b;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.dist > o.dist) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
