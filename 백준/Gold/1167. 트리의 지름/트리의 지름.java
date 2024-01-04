import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Node>[] lists;
    private static boolean[] visited;
    private static int max = 0;
    private static int node = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        lists = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) {
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());
                lists[u].add(new Node(v, cost));
            }
        }
        visited = new boolean[V + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[V + 1];
        visited[node] = true;
        dfs(node, 0);

        System.out.println(max);
    }

    private static void dfs(int start, int cost) {
        if (max < cost) {
            max = cost;
            node = start;
        }

        for (Node node : lists[start]) {
            if (!visited[node.num]) {
                visited[node.num] = true;
                dfs(node.num, cost + node.cost);
            }
        }
    }

    private static class Node {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
}
