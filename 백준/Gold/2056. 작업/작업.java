import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static List<Integer>[] lists;
    private static int[] costs;
    private static int[] indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lists = new ArrayList[N + 1];
        costs = new int[N + 1];
        indegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            indegree[i] = m;
            for (int j = 0; j < m; j++) {
                int node = Integer.parseInt(st.nextToken());
                lists[node].add(i);
            }
        }

        System.out.println(search());
    }

    private static int search() {
        Queue<Integer> queue = new LinkedList<>();

        int[] results = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            results[i] = costs[i];

            //선행 노드가 없으면 큐에 담는다.
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : lists[node]) {
                indegree[next]--;

                results[next] = Math.max(results[next], results[node] + costs[next]);

                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(results[i], max);
        }

        return max;
    }
}
