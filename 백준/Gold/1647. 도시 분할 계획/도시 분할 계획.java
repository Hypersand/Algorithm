import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for (int i = 1; i<=N; i++) {
            parents[i] = i;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.add(new Node(A, B, C));
        }

        int answer = 0;
        int max = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if (find(node.A) != find(node.B)) {
                union(node.A, node.B);
                answer += node.cost;
                max = node.cost;
            }
        }

        System.out.println(answer - max);
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

    private static int find(int x) {
        if(parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private static class Node implements Comparable<Node> {
        int A;
        int B;
        int cost;

        public Node(int A, int B, int cost) {
            this.A = A;
            this.B = B;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }
}