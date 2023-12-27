import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int K;
    private static int[] seconds = new int[100001];
    private static int[] parents = new int[100001];
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N >= K) {
            StringBuilder sb = new StringBuilder();
            sb.append(N - K).append("\n");
            for (int i = N; i >= K; i--) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        find();
        Stack<Integer> stack = new Stack<>();
        int node = K;
        while (node != N) {
            stack.push(node);
            node = parents[node];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(seconds[K] - 1).append("\n");
        sb.append(N).append(" ");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    private static void find() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        seconds[N] = 1;

        while (!queue.isEmpty()) {
            int curNum = queue.poll();
            if (curNum == K) return;
            for (int i = 0; i < 3; i++) {
                int nextNum;
                if (i == 0) {
                    nextNum = curNum + 1;
                } else if (i == 1) {
                    nextNum = curNum - 1;
                } else {
                    nextNum = curNum * 2;
                }

                if (nextNum < 0 || nextNum > 100000) continue;
                if (seconds[nextNum] == 0) {
                    queue.add(nextNum);
                    seconds[nextNum] = seconds[curNum] + 1;
                    parents[nextNum] = curNum;
                }
            }

        }

    }
}
