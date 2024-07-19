import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int N;
    private static boolean[] visited;
    private static int answer = Integer.MAX_VALUE;
    private static List<Node> list = new ArrayList<>();
    private static List<Integer> orders = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            String line =  br.readLine();
            int cnt = 0;
            for (int j = 0; j < line.length() - 1; j++) {
                if (line.charAt(j) != line.charAt(j + 1)) {
                    cnt++;
                }
            }
            list.add(new Node(line.charAt(0), line.charAt(line.length() - 1), cnt));
        }

        perm(0);

        System.out.println(answer);
    }

    private static void perm(int size) {
        if (size == N) {
            int cnt = 0;
            int lastWord = list.get(orders.get(0)).startWord;
            for (int i = 0; i < N; i++) {
                int order = orders.get(i);
                if (lastWord != list.get(order).startWord) {
                    cnt++;
                }
                cnt += list.get(order).cnt;
                lastWord = list.get(order).endWord;
            }

            answer = Math.min(cnt, answer);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                orders.add(i);
                perm(size + 1);
                visited[i] = false;
                orders.remove(orders.size() - 1);
            }
        }

    }

    private static class Node {
        private int startWord;
        private int endWord;
        private int cnt;

        public Node(int startWord, int endWord, int cnt) {
            this.startWord = startWord;
            this.endWord = endWord;
            this.cnt = cnt;
        }
    }
}
