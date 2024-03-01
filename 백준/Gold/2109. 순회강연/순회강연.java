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
        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            list.add(new Node(pay, day));
        }

        Collections.sort(list, (n1, n2) -> (n1.pay == n2.pay) ? n1.day - n2.day : n2.pay - n1.pay);
        boolean[] visited = new boolean[10001];
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            int day = list.get(i).day;
            int pay = list.get(i).pay;
            for (int j = day; j >= 1; j--) {
                if (!visited[j]) {
                    visited[j] = true;
                    answer += pay;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    private static class Node {
        private final int pay;
        private final int day;

        public Node(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
    }
}
