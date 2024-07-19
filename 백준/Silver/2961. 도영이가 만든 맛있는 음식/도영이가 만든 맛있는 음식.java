import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static boolean[] visited;
    private static List<Node> list;
    private static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // 1개 선택부터 N개 선택까지
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N];
            comb(i, 0, 0);
        }

        System.out.println(answer);
    }


    private static void comb(int maxSize, int size, int idx) {
        if (size == maxSize) {
            int xSum = 1;
            int ySum = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    xSum *= list.get(i).x;
                    ySum += list.get(i).y;
                }
            }

            answer = Math.min(answer, Math.abs(xSum - ySum));
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(maxSize, size + 1, i);
                visited[i] = false;
            }
        }

    }

    private static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
