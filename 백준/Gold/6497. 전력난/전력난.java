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
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) break;
            parents = new int[m];
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                parents[i] = i;
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                max += z;
                list.add(new Node(x, y, z));
            }

            Collections.sort(list);
            int answer = 0;
            for (int i = 0; i < list.size(); i++) {
                Node node = list.get(i);
                if (find(node.x) != find(node.y)) {
                    union(node.x, node.y);
                    answer += node.cost;
                }
            }

            sb.append(max - answer).append("\n");
        }

        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        if (pA > pB) {
            parents[pA] = pB;
            return;
        }
        parents[pB] = pA;
    }

    private static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    private static class Node implements Comparable<Node> {
        private int x;
        private int y;
        private int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
