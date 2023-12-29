import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] parents;
    private static List<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            list.add(new Node(i, Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }


        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            int pNode = find(node.idx);
            if (pNode != 0) {
                union(0, pNode);
                K -= node.cost;
                answer += node.cost;
            }
        }

        if (K < 0) {
            System.out.println("Oh no");
        } else {
            System.out.println(answer);
        }
    }

    private static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    private static void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        if (pA > pB) {
            parents[pA] = pB;
        } else {
            parents[pB] = pA;
        }
    }

    private static class Node implements Comparable<Node> {
        private int idx;
        private int cost;

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
