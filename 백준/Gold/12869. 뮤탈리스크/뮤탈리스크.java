import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static int[][] dir = {{9, 3, 1}, {9, 1, 3}, {1, 3, 9}, {1, 9, 3}, {3, 1, 9}, {3, 9, 1}};
    private static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[3];
        visited = new boolean[61][61][61];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(arr[0], arr[1], arr[2], 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = node.x - dir[i][0];
                int ny = node.y - dir[i][1];
                int nz = node.z - dir[i][2];
                if (nx < 0) nx = 0;
                if (ny < 0) ny = 0;
                if (nz < 0) nz = 0;

                if (visited[nx][ny][nz]) continue;
                if (nx <= 0 && ny <= 0 && nz <= 0) {
                    return node.cnt + 1;
                } else {
                    queue.add(new Node(nx, ny, nz, node.cnt + 1));
                    visited[nx][ny][nz] = true;
                }
            }
        }

        return 0;
    }

    private static class Node {
        int x;
        int y;
        int z;
        int cnt;

        public Node(int x, int y, int z, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }

}
