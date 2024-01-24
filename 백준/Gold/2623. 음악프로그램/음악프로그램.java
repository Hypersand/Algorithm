import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[] inDegrees;
    private static List<Integer>[] lists;
    private static StringBuilder sb = new StringBuilder();
    private static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        inDegrees = new int[N + 1];
        lists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int cur = 0;
            if (num > 0) {
                cur = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j < num; j++) {
                int node = Integer.parseInt(st.nextToken());
                lists[cur].add(node);
                inDegrees[node]++;
                cur = node;
            }
        }

        search();

        for (int i = 1; i < lists.length; i++) {
            for (int node : lists[i]) {
                //i번 노드를 자식 노드보다 늦게 방문? -> 오류
                if (visited[i] >= visited[node]) {
                    System.out.println(0);
                    return;
                }
            }
        }

        System.out.println(sb);
    }

    private static void search() {
        visited = new int[N + 1];
        int idx = 1;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
                visited[i] = idx++;
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = idx++;
            sb.append(node).append("\n");
            for (int next : lists[node]) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}
