import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] dp = new int[D + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if (end > D || dist > end - start) {
                continue;
            }

            list.add(new Node(start, end, dist));
        }

        for (int i = 1; i <= D; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < list.size(); j++) {
                Node node = list.get(j);
                if (node.end == i) {
                    dp[i] = Math.min(dp[i], dp[node.start] + node.cost);
                }
            }
        }

        System.out.println(dp[D]);
    }

    private static class Node {
        private int start;
        private int end;
        private int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
