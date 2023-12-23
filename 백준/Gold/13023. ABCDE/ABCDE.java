import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer>[] lists;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        lists = new List[N];
        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, 0);
        }

        System.out.println(0);
    }

    private static void dfs(int start, int depth) {
        if (depth == 4) {
            System.out.println(1);
            System.exit(0);
        }

        for (int num : lists[start]) {
            if (!visited[num]) {
                visited[num] = true;
                dfs(num, depth + 1);
                visited[num] = false;
            }
        }
    }
}
