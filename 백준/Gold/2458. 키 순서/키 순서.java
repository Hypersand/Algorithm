import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] lists = new ArrayList[N + 1];
        List<Integer>[] reverseLists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
            reverseLists[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            reverseLists[b].add(a);
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int cnt = bfs(lists, i) + bfs(reverseLists, i);
            if (cnt >= N - 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static int bfs(List<Integer>[] lists, int node) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int next : lists[num]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
