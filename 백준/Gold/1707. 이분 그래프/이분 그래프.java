import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] group;
    private static List<Integer>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            group = new int[V + 1];
            lists = new ArrayList[V + 1];
            for (int j = 1; j <= V; j++) {
                lists[j] = new ArrayList<>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                lists[u].add(v);
                lists[v].add(u);
            }

            for (int j = 1; j <= V; j++) {
                if (group[j] == 0) {
                    group[j] = 1;
                    dfs(j);
                }
            }

            boolean isBinaryGraph = true;
            for (int j = 1; j <= V; j++) {
                int groupNum = group[j];
                for (int node : lists[j]) {
                    if (groupNum == group[node]) {
                        isBinaryGraph = false;
                        break;
                    }
                }

                if (!isBinaryGraph) {
                    break;
                }
            }

            if (isBinaryGraph) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void dfs(int node) {
        for (int next : lists[node]) {
            if (group[node] == 1 && group[next] == 0) {
                group[next] = 2;
                dfs(next);
                continue;
            }

            if (group[node] == 2 && group[next] == 0) {
                group[next] = 1;
                dfs(next);
            }
        }

    }
}
