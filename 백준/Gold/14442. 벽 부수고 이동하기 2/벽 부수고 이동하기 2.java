import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K;
    private static int[][] map;
    private static int[][] destroys;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        destroys = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                destroys[i][j] = INF;
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0));
        destroys[0][0] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == N - 1 && node.y == M - 1) {
                return node.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 1) {
                    if (node.destroyCnt + 1 < destroys[nx][ny] && node.destroyCnt < K) {
                        destroys[nx][ny] = node.destroyCnt + 1;
                        queue.add(new Node(nx, ny, node.dist + 1, destroys[nx][ny]));
                    }

                } else {
                    if (node.destroyCnt < destroys[nx][ny]) {
                        destroys[nx][ny] = node.destroyCnt;
                        queue.add(new Node(nx, ny, node.dist + 1, destroys[nx][ny]));
                    }
                }
            }
        }
        return -1;
    }

    private static class Node {
        private int x;
        private int y;
        private int dist;
        private int destroyCnt;

        public Node(int x, int y, int dist, int destroyCnt) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.destroyCnt = destroyCnt;
        }
    }
}
