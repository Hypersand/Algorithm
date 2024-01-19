import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int K;
    private static int[][] arr;
    private static int[][] destroyArr;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static final int INF = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        destroyArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
                destroyArr[i][j] = INF;
            }
        }
        int cost = bfs();
        System.out.println(cost);
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0));
        destroyArr[0][0] = 0;
        int minDistance = INF;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == N - 1 && node.y == M - 1) {
                minDistance = Math.min(minDistance, node.cost);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                //이미 방문한 곳이라면
                if (destroyArr[nx][ny] != INF) {
                    //만약 현재까지 벽을 부순 갯수가 기록된 것보다 더 적다면 재방문
                    if (destroyArr[nx][ny] > node.destroyCnt) {
                        if (arr[nx][ny] == 0) {
                            destroyArr[nx][ny] = node.destroyCnt;
                            queue.add(new Node(nx, ny, node.cost + 1, node.destroyCnt));
                            continue;
                        }
                    }
                    if (destroyArr[nx][ny] > node.destroyCnt + 1 && arr[nx][ny] == 1) {
                        destroyArr[nx][ny] = node.destroyCnt + 1;
                        queue.add(new Node(nx, ny, node.cost + 1, node.destroyCnt + 1));
                    }
                    continue;
                }
                //처음 방문한다면
                if (arr[nx][ny] == 0) {
                    destroyArr[nx][ny] = node.destroyCnt;
                    queue.add(new Node(nx, ny, node.cost + 1, node.destroyCnt));
                } else {
                    if (node.destroyCnt == K) continue;
                    destroyArr[nx][ny] = node.destroyCnt + 1;
                    queue.add(new Node(nx, ny, node.cost + 1, node.destroyCnt + 1));
                }
            }
        }

        if (minDistance == INF) {
            return -1;
        } else {
            return minDistance;
        }
    }


    private static class Node {
        private int x;
        private int y;
        private int cost;
        private int destroyCnt;

        public Node(int x, int y, int cost, int destroyCnt) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.destroyCnt = destroyCnt;
        }
    }
}
