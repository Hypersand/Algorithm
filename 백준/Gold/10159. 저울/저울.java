import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Integer>[] lists = new ArrayList[N + 1];
        List<Integer>[] reverseLists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
            reverseLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            reverseLists[b].add(a);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int cnt1 = bfs(lists, i);
            int cnt2 = bfs(reverseLists, i);
            sb.append(N - (cnt1 + cnt2 - 1)).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(List<Integer>[] lists, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        queue.add(start);
        int cnt = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : lists[node]) {
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
