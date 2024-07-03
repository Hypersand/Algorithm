import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int hx, hy, ex, ey;
    private static int[][] arr;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][][] dists; // [][][0] : 벽을 안뚫고 방문, [][][1] : 벽을 뚫고 방문
    private static final int INF = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        hx = Integer.parseInt(st.nextToken()) - 1;
        hy = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken()) - 1;
        ey = Integer.parseInt(st.nextToken()) - 1;

        arr = new int[N][M];
        dists = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 2; k++) {
                    dists[i][j][k] = INF;
                }
            }
        }

        find();
        int answer = Math.min(dists[ex][ey][0], dists[ex][ey][1]);
        if (answer == INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    private static void find() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(hx, hy, 0, false));
        dists[hx][hy][0] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (node.passedWall && arr[nx][ny] == 1) continue;
                if (arr[nx][ny] == 0) {
                    boolean flag = false;
                    if (node.passedWall) {
                        if (dists[nx][ny][1] > node.dist + 1) {
                            flag = true;
                            dists[nx][ny][1] = node.dist + 1;
                        }
                    } else {
                        if (dists[nx][ny][0] > node.dist + 1) {
                            flag = true;
                            dists[nx][ny][0] = node.dist + 1;
                        }
                    }
                    if (flag) {
                        queue.add(new Node(nx, ny, node.dist + 1, node.passedWall));
                    }
                } else {
                    if (dists[nx][ny][1] > node.dist + 1) {
                        dists[nx][ny][1] = node.dist + 1;
                        queue.add(new Node(nx, ny, node.dist + 1, true));
                    }
                }
            }

        }

    }

    private static class Node {
        private int x;
        private int y;
        private int dist;
        private boolean passedWall;

        public Node(int x, int y, int dist, boolean passedWall) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.passedWall = passedWall;
        }
    }

}
