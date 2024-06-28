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
        int n = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new Node(d, p));
        }

        Collections.sort(list);

        boolean[] visited = new boolean[10001];
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            for (int j = node.day; j > 0; j--) {
                if (!visited[j]) {
                    visited[j] = true;
                    sum += node.pay;
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    private static class Node implements Comparable<Node> {
        private int day;
        private int pay;

        public Node(int day, int pay) {
            this.day = day;
            this.pay = pay;
        }

        @Override
        public int compareTo(Node n) {
            if (n.pay == this.pay) {
                return n.day - this.day;
            }
            return n.pay - this.pay;
        }
    }
}
