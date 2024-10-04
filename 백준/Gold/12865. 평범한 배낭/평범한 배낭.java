import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list.add(new Node(weight, value));
        }

        Collections.sort(list);

        int[] dp = new int[K + 1];
        int max = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = K; j >= 1; j--) {
                if (j - list.get(i).weight < 0) continue;
                dp[j] = Math.max(dp[j], dp[j - list.get(i).weight] + list.get(i).value);
                max = Math.max(dp[j], max);
            }
        }

        System.out.println(max);
    }

    private static class Node implements Comparable<Node> {
        private int weight;
        private int value;

        public Node(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if (this.weight == o.weight) {
                return o.value - this.value;
            }
            return this.weight - o.weight;
        }
    }
}
