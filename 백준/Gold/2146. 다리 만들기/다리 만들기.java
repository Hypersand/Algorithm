import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    private static int[][] arr;
    private static boolean[][] visited;
    private static int N;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static List<Point> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, islandNum);
                    islandNum++;
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (Point p : list) {
            int cost = findMinDistance(p.x, p.y, arr[p.x][p.y]);
            answer = Math.min(cost, answer);
        }
        System.out.println(answer);
    }

    //섬의 모서리 점에서 가장 가까운 섬까지의 최단거리 구하기
    private static int findMinDistance(int x, int y, int islandNum) {
        visited = new boolean[N][N];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (arr[nx][ny] == islandNum || visited[nx][ny]) continue;
                if (arr[nx][ny] > 0) {
                    return node.cost;
                }
                queue.add(new Node(nx, ny, node.cost + 1));
                visited[nx][ny] = true;
            }
        }
        return Integer.MAX_VALUE;
    }

    private static void bfs(int x, int y, int islandNum) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        arr[x][y] = islandNum;
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nearX = p.x + dx[i];
                int nearY = p.y + dy[i];
                if (nearX < 0 || nearY < 0 || nearX >= N || nearY >= N) continue;
                if (arr[nearX][nearY] == 0) {
                    list.add(new Point(p.x, p.y));
                    break;
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (arr[nx][ny] == 0 || visited[nx][ny]) continue;
                arr[nx][ny] = islandNum;
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }

    }

    private static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
