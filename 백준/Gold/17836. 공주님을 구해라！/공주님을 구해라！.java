import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, T;
    private static int[][] arr;
    private static int[][][] dp; // 0 : gram X , 1 : gram O
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static final int INF = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dp = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = INF;
                }
            }
        }

        find();

        int answer = Math.min(dp[N - 1][M - 1][0], dp[N - 1][M - 1][1]);
        if (answer <= T) {
            System.out.println(answer);
            return;
        }

        System.out.println("Fail");
    }

    private static void find() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, false));
        dp[0][0][0] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (!cur.hasGram) {
                    if (arr[nx][ny] == 1) continue;
                    boolean gram = false;
                    if (arr[nx][ny] == 2) {
                        if (dp[nx][ny][0] > cur.dist + 1) {
                            gram = true;
                            dp[nx][ny][0] = cur.dist + 1;
                            queue.add(new Node(nx, ny, cur.dist + 1, gram));
                        }
                        continue;
                    }

                    if (dp[nx][ny][0] > cur.dist + 1) {
                        dp[nx][ny][0] = cur.dist + 1;
                        queue.add(new Node(nx, ny, cur.dist + 1, gram));
                    }
                    continue;
                }

                // 그람을 가지고 있는 경우 -> 벽이든 빈방이든 모두 탐색 가능
                if (dp[nx][ny][1] > cur.dist + 1) {
                    dp[nx][ny][1] = cur.dist + 1;
                    queue.add(new Node(nx, ny, cur.dist + 1, true));
                }
            }
        }

    }
    private static class Node {
        private int x;
        private int y;
        private int dist;
        private boolean hasGram;

        public Node(int x, int y, int dist, boolean hasGram) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.hasGram = hasGram;
        }
    }
}
