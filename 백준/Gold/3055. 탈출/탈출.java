import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int R;
    private static int C;
    private static String[][] arr;
    private static int[][] route;
    private static boolean[][] isWaterVisited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static Point startP;
    private static Point endP;
    private static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[R][C];
        route = new int[R][C];
        isWaterVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                if (arr[i][j].equals("S")) {
                    startP = new Point(i, j);
                    continue;
                }
                if (arr[i][j].equals("D")) {
                    endP = new Point(i, j);
                    continue;
                }
                if (arr[i][j].equals("*")) {
                    queue.add(new Node(0, i, j));
                    isWaterVisited[i][j] = true;

                }
            }
        }

        move();
        if (route[endP.x][endP.y] == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(route[endP.x][endP.y]);
        }
    }

    private static void move() {
        boolean[][] isAnimalVisited = new boolean[R][C];

        //Node Class type : 0 -> 물,  type : 1 -> 고슴도치
        queue.add(new Node(1, startP.x, startP.y));
        isAnimalVisited[startP.x][startP.y] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (isOutOfBounds(nx, ny)) continue;
                if (arr[nx][ny].equals("X")) continue;
                //물의 이동이라면
                if (node.type == 0) {
                    //이미 물이 이동한 칸이라면 패스
                    if (isWaterVisited[nx][ny]) continue;
                    //이동할 칸이 동굴이라면 패스
                    if (arr[nx][ny].equals("D")) continue;
                    queue.add(new Node(0, nx, ny));
                    isWaterVisited[nx][ny] = true;
                    continue;
                }
                //고슴도치의 이동이라면
                //이미 물이 이동한 칸이거나 이미 방문했던 칸이라면 패스
                if (isWaterVisited[nx][ny] || isAnimalVisited[nx][ny]) continue;
                queue.add(new Node(1, nx, ny));
                route[nx][ny] = route[node.x][node.y] + 1;
                isAnimalVisited[nx][ny] = true;
            }
        }
    }

    private static boolean isOutOfBounds(int x, int y) {
        return x < 0 || y < 0 || x >= R || y >= C;
    }

    private static class Node {
        private int type;
        private int x;
        private int y;

        public Node(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }
}
