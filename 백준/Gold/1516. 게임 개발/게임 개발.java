import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static List<Integer>[] lists;
    private static int[] inDegrees;
    private static int[] costs;
    private static int[] dp;
    private static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lists = new ArrayList[N + 1];
        inDegrees = new int[N + 1];
        costs = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) break;
                lists[node].add(i);
                inDegrees[i]++;
            }
        }

        search();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dp[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void search() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegrees[i] == 0) {
                dp[i] = costs[i];
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : lists[node]) {
                inDegrees[next]--;
                dp[next] = Math.max(dp[next], dp[node] + costs[next]);
                if (inDegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}
