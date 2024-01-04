import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static String[][][] arr; //층, 행, 열
    private static int[][][] visited;
    private static int L;
    private static int R;
    private static int C;
    private static int[] dh = {-1, 1, 0, 0, 0, 0};
    private static int[] dx = {0, 0, -1, 1, 0, 0};
    private static int[] dy = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            arr = new String[L][R][C];
            visited = new int[L][R][C];
            Node start = new Node(0, 0, 0);
            Node end = new Node(0, 0, 0);
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String[] line = br.readLine().split("");
                    for (int k = 0; k < C; k++) {
                        arr[i][j][k] = line[k];
                        if (arr[i][j][k].equals("S")) {
                            start = new Node(i, j, k);
                        }
                        if (arr[i][j][k].equals("E")) {
                            end = new Node(i, j, k);
                        }
                    }
                }
                br.readLine();
            }
            if (bfs(start, end)) {
                sb.append("Escaped in ").append(visited[end.height][end.row][end.col] - 1).append(" minute(s).").append("\n");
            } else {
                sb.append("Trapped!").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean bfs(Node start, Node end) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited[start.height][start.row][start.col] = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.equals(end)) {
                return true;
            }
            for (int i = 0; i < 6; i++) {
                int nh = node.height + dh[i];
                int nx = node.row + dx[i];
                int ny = node.col + dy[i];
                if (nh < 0 || nx < 0 || ny < 0 || nh >= L || nx >= R || ny >= C) continue;
                if (visited[nh][nx][ny] != 0) continue;
                if (arr[nh][nx][ny].equals("#"))continue;
                visited[nh][nx][ny] = visited[node.height][node.row][node.col] + 1;
                queue.add(new Node(nh, nx, ny));
            }
        }

        return false;
    }

    private static class Node {
        int height;
        int row;
        int col;

        public Node(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }

        public boolean equals(Node node) {
            if (this.height == node.height && this.row == node.row && this.col == node.col) {
                return true;
            }
            return false;
        }
    }
}
