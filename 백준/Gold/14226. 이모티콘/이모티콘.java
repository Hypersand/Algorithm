import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int S;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        visited = new boolean[2001][2001];
        bfs();
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 1, 0));
        visited[1][0] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.screen == S) {
                System.out.println(node.second);
                return;
            }

            if (node.screen > 1000 || node.clip > 1000) continue;

            //1.화면에 있는 이모티콘 모두 복사
            int clip = node.screen;
            if (!visited[node.screen][clip]) {
                queue.add(new Node(node.second + 1, node.screen, clip));
                visited[node.screen][clip] = true;
            }

            //2.클립보드에 있는 모든 이모티콘 붙여넣기
            if (node.clip != 0) {
                int screen = node.clip + node.screen;
                if (!visited[screen][node.clip]) {
                    queue.add(new Node(node.second + 1, screen, node.clip));
                    visited[screen][node.clip] = true;
                }
            }

            //3.화면에 있는 이모티콘 하나 삭제
            if ((node.screen) != 0) {
                int screen = node.screen - 1;
                if (!visited[screen][node.clip]) {
                    queue.add(new Node(node.second + 1, screen, node.clip));
                    visited[screen][node.clip] = true;
                }

            }

        }
    }

    private static class Node {
        int second;
        int screen;
        int clip;

        public Node(int second, int screen, int clip) {
            this.second = second;
            this.screen = screen;
            this.clip = clip;
        }
    }
}
