import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    private static int[][] visited;
    private static int N;
    private static int M;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static final int INF = 10000000;
    private static int answer = INF;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new int[N][M]; //0 : 방문 X  1 : 안부수고 방문 2 : 부수고 방문
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
                visited[i][j] = INF;
            }
        }
        bfs();
        if (answer == INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0));
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == N - 1 && node.y == M - 1) {
                answer = Math.min(node.distance, answer);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                //visited 값 : INF -> 아직 방문 안함, 0 -> 벽을 안부수고 방문, 1 -> 벽을 부수고 방문
                if (visited[nx][ny] > node.destroyCnt) {
                    //빈방일 때는 벽을 부순 여부와 상관없이 모두 방문 해야 된다.
                    if (arr[nx][ny] == 0) {
                        queue.add(new Node(nx, ny, node.distance + 1, node.destroyCnt));
                        visited[nx][ny] = node.destroyCnt;
                        continue;
                    }

                    //빈방이 아닐 때 현재까지 부순 카운트가 0이어야지 방문 가능
                    if (node.destroyCnt == 0) {
                        queue.add(new Node(nx, ny, node.distance + 1, node.destroyCnt + 1));
                        visited[nx][ny] = 1;
                    }
                }
            }
        }

    }

    private static class Node {
        private int x;
        private int y;
        private int distance;
        private int destroyCnt;

        public Node(int x, int y, int distance, int destroyCnt) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.destroyCnt = destroyCnt;
        }
    }
}
