import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer>[] lists;
    private static boolean[] visited;
    private static int[] answers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        lists = new List[N + 1];
        visited = new boolean[N + 1];
        answers = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList();
        }


        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            lists[u].add(v);
            lists[v].add(u);
        }

        visited[R] = true;
        find(R);

        for (int i = 0; i < Q; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(answers[num]);
        }


    }

    private static int find(int node) {
        for (int cur : lists[node]) {
            if (!visited[cur]) {
                visited[cur] = true;
                answers[node] += find(cur);
            }
        }

        return answers[node] += 1;
    }
}
