import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static int cnt = 0;
    private static int[] map = new int[100001];
    private static int minSec = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(map, Integer.MAX_VALUE);

        bfs();
        System.out.println(minSec);
        System.out.println(cnt);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));
        map[N] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.num == K) {
                if (node.sec < minSec) {
                    cnt = 1;
                    minSec = node.sec;
                } else if (node.sec == minSec) {
                    cnt++;
                }
                continue;
            }

            //뒤로가기, 앞으로가기, 두배가기
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    int tmp = node.num - 1;
                    if (tmp >= 0 && minSec >= node.sec && map[tmp] >= node.sec + 1) {
                        queue.add(new Node(tmp, node.sec + 1));
                        map[tmp] = node.sec + 1;
                    }
                } else if (i == 1) {
                    int tmp = node.num + 1;
                    if (tmp <= 100000 && minSec >= node.sec && map[tmp] >= node.sec + 1) {
                        queue.add(new Node(tmp, node.sec + 1));
                        map[tmp] = node.sec + 1;
                    }
                } else {
                    int tmp = node.num * 2;
                    if (tmp <= 100000 && minSec >= node.sec && map[tmp] >= node.sec + 1) {
                        queue.add(new Node(tmp, node.sec + 1));
                        map[tmp] = node.sec + 1;
                    }
                }
            }
        }
    }

    private static class Node {
        private int num;
        private int sec;

        public Node(int num, int sec) {
            this.num = num;
            this.sec = sec;
        }
    }
}
