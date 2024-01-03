import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] group;
    private static List<Integer>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
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
            group = new int[V + 1];
            //0 : 아직 그룹에 안속함, 1 : A그룹, 2 : B그룹
            for (int j = 1; j <= V; j++) {
                if (group[j] == 0) {
                    group[j] = 1;
                    dfs(j);
                }
            }

            boolean canMake = true;
            for (int j = 1; j <= V; j++) {
                int num = group[j];
                for (int node : lists[j]) {
                    if (group[node] == num) {
                        canMake = false;
                        break;
                    }
                }
                if (!canMake) {
                    break;
                }
            }
            if (!canMake) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }

        }
        System.out.println(sb);
    }

    private static void dfs(int node) {
        for (int next : lists[node]) {
            //뽑은 노드가 아직 그룹에 안속해있다면
            if (group[next] == 0) {
                //만약 이전 노드의 그룹이 A라면
                if (group[node] == 1) {
                    group[next] = 2;
                    dfs(next);
                }
                //만약 이전 노드의 그룹이 B라면
                else {
                    group[next] = 1;
                    dfs(next);
                }
            }

        }

    }
}
