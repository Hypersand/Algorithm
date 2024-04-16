import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;

    private static int[][] map;
    private static boolean[][][] visited; // 0 : 지팡이를 안쓰고 방문, 1 : 지팡이를 쓰고 방문
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static Point start = null;
    private static Point end = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        st = new StringTokenizer(br.readLine());
        start = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        st = new StringTokenizer(br.readLine());
        end = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(find());
    }

    private static int find() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start.x, start.y, 0, 0));
        visited[start.x][start.y][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 목적지 도착
            if (cur.x == end.x && cur.y == end.y) return cur.dist;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 벽이고, 아직 벽을 부순적이 없을때
                if (map[nx][ny] == 1 && cur.isUsedStaff == 0) {
                    visited[nx][ny][0] = true;
                    queue.add(new Node(nx, ny, cur.dist + 1, 1));
                    continue;
                }

                // 길일때 방문한 적이 없다면
                if (map[nx][ny] == 0 && !visited[nx][ny][cur.isUsedStaff]) {
                    visited[nx][ny][cur.isUsedStaff] = true;
                    queue.add(new Node(nx, ny, cur.dist + 1, cur.isUsedStaff));
                }
            }
        }

        return -1;
    }

    private static class Node {
        private int x;
        private int y;
        private int dist;
        private int isUsedStaff;

        public Node(int x, int y, int dist, int isUsedStaff) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.isUsedStaff = isUsedStaff;
        }
    }
}
