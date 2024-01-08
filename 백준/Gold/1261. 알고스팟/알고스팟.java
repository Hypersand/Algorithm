import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int M;
    private static int N;
    private static int[][] arr;
    private static int[][] destroyArr;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static final int INF = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        destroyArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
                if (arr[i][j] == 1) {
                }
            }
            Arrays.fill(destroyArr[i], INF);
        }

        bfs();
        System.out.println(destroyArr[N - 1][M - 1]);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        destroyArr[0][0] = 0;
        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                //벽이라면?
                if (arr[nx][ny] == 1) {
                    //부수고 간 기록보다 더 적게 부술 수 있다면 추가
                    if (destroyArr[node.x][node.y] + 1 < destroyArr[nx][ny]) {
                        destroyArr[nx][ny] = destroyArr[node.x][node.y] + 1;
                        queue.add(new Node(nx, ny));
                    }
                    continue;
                }

                //빈방이라면?
                //처음 방문하는 빈방
                if (destroyArr[nx][ny] == INF) {
                    destroyArr[nx][ny] = destroyArr[node.x][node.y];
                    queue.add(new Node(nx, ny));
                    continue;
                }

                //이미 방문한 적 있는 빈방
                if (destroyArr[nx][ny] > destroyArr[node.x][node.y]) {
                    destroyArr[nx][ny] = destroyArr[node.x][node.y];
                    queue.add(new Node(nx, ny));
                }
            }

        }



    }

    private static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
