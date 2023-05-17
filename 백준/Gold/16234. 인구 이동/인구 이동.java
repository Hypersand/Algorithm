

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, L, R;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static ArrayList<Node> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int moveDays = 0;

        while (true) {
            boolean isMove = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int avg = bfs(i, j);
                        if (list.size() > 1) {
                            movePopulation(avg);
                            isMove = true;
                        }
                    }
                }
            }
            if (!isMove) break;

            moveDays++;
        }

        System.out.println(moveDays);
    }

    public static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        list = new ArrayList<>();

        int sum = map[x][y];

        queue.add(new Node(x, y));
        list.add(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int next_x = now.x + dx[k];
                int next_y = now.y + dy[k];
                if (next_x >= 0 && next_y >= 0 && next_x < N && next_y < N && !visited[next_x][next_y]) {
                    int diff = Math.abs(map[now.x][now.y] - map[next_x][next_y]);
                    if (diff >= L && diff <= R) {
                        queue.add(new Node(next_x, next_y));
                        visited[next_x][next_y] = true;
                        sum += map[next_x][next_y];
                        list.add(new Node(next_x, next_y));
                    }
                }
            }
        }

        return sum/list.size();
    }

    public static void movePopulation(int avg) {
        for (Node node : list) {
            map[node.x][node.y] = avg;
        }
    }

    public static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
