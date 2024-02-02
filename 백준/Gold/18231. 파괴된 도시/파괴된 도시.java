import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static List<Integer>[] lists;
    private static boolean[] visited;
    private static boolean[] isDestroyed;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N + 1];
        isDestroyed = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            lists[u].add(v);
            lists[v].add(u);
        }

        int K = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int city = Integer.parseInt(st.nextToken());
            isDestroyed[city] = true;
        }

        List<Integer> bombList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!isDestroyed[i]) continue;
            boolean isBomb = true;
            for (int next : lists[i]) {
                //인접한 곳에 파괴되지 않은 도시가 있다면 폭탄을 터뜨릴 수 없다.
                if (!isDestroyed[next]) {
                    isBomb = false;
                    break;
                }
            }

            if (!isBomb) continue;
            bombList.add(i);
            visited[i] = true;
        }

        for (int cur : bombList) {
            for (int next : lists[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (isDestroyed[i] && !visited[i]) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bombList.size()).append("\n");
        for (int bomb : bombList) {
            sb.append(bomb).append(" ");
        }

        System.out.println(sb);
    }
}
