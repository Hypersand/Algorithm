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
            list.add(new Node(p, d));
        }

        Collections.sort(list);
        int answer = 0;
        int[] arr = new int[10001];
        for (int i = 0; i < n; i++) {
            Node node = list.get(i);
            if (arr[node.day] < node.pay) {
                arr[node.day] = node.pay;
                answer += node.pay;
            } else {
                for (int j = node.day - 1; j > 0; j--) {
                    if (arr[j] < node.pay) {
                        arr[j] = node.pay;
                        answer += node.pay;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static class Node implements Comparable<Node> {
        private int pay;
        private int day;

        private Node(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        @Override
        public int compareTo(Node node) {
            if (node.pay == this.pay) {
                return node.day - this.day;
            }
            return node.pay - this.pay;
        }
    }
}
