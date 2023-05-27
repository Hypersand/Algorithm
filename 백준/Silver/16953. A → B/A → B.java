
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int ans = find(A, B);

        if (ans != 0) {
            System.out.println(ans + 1);
        }

        if (ans == 0) {
            System.out.println(-1);
        }

    }

    public static int find(int A, int B) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(A, 0));

        int cnt = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    int tmp = now.value * 2;
                    if (tmp < B) {
                        queue.add(new Node(tmp, now.idx + 1));
                        continue;
                    }

                    if (tmp == B) {
                        cnt = now.idx +1;
                        break;
                    }
                    continue;
                }

                long k = Long.parseLong(String.valueOf(now.value) + "1");

                if (k < B) {
                    queue.add(new Node((int)k, now.idx + 1));
                    continue;
                }

                if (k == B) {
                    cnt = now.idx + 1;
                    break;
                }
            }
        }

        return cnt;
    }

    public static class Node {
        int value;
        int idx;

        public Node(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }
}
