import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Node> stack = new Stack<>();
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek().num < arr[i]) {
                Node node = stack.pop();
                answer[node.idx] = arr[i];
            }

            stack.push(new Node(arr[i], i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (answer[i] != 0) {
                sb.append(answer[i]).append(" ");
                continue;
            }
            sb.append("-1").append(" ");
        }

        System.out.println(sb);
    }

    private static class Node {
        private final int num;
        private final int idx;

        public Node(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
