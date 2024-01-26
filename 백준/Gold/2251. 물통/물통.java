import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int A, B, C;
    private static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[A + 1][B + 1][C + 1];

        bfs();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= B; i++) {
            for (int j = 0; j <= C; j++) {
                if (visited[0][i][j]) {
                    set.add(j);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : set) {
            list.add(num);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        visited[0][0][C] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, C));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int a = node.a;
            int b = node.b;
            int c = node.c;
            //1. a에서 옮기기
            if (a + b <= B) {
                if (!visited[0][a + b][c]) {
                    queue.add(new Node(0, a + b, c));
                    visited[0][a + b][c] = true;
                }

            } else {
                int canMove = B - b;
                if (!visited[a - canMove][b + canMove][c]) {
                    queue.add(new Node(a - canMove, b + canMove, c));
                    visited[a - canMove][b + canMove][c] = true;
                }
            }

            if (a + c <= C) {
                if (!visited[0][b][a + c]) {
                    queue.add(new Node(0, b, a + c));
                    visited[0][b][a + c] = true;
                }

            } else {
                int canMove = C - c;
                if (!visited[a - canMove][b][c + canMove]) {
                    queue.add(new Node(a - canMove, b, c + canMove));
                    visited[a - canMove][b][c + canMove] = true;
                }

            }

            //2. b에서 옮기기
            if (b + a <= A) {
                if (!visited[b + a][0][c]) {
                    queue.add(new Node(b + a, 0, c));
                    visited[b + a][0][c] = true;
                }

            } else {
                int canMove = A - a;
                if (!visited[a + canMove][b - canMove][c]) {
                    queue.add(new Node(a + canMove, b - canMove, c));
                    visited[a + canMove][b - canMove][c] = true;
                }
            }

            if (b + c <= C) {
                if (!visited[a][0][b+c]) {
                    queue.add(new Node(a, 0, b + c));
                    visited[a][0][b + c] = true;
                }

            } else {
                int canMove = C - c;
                if (!visited[a][b - canMove][c + canMove]) {
                    queue.add(new Node(a, b - canMove, c + canMove));
                    visited[a][b - canMove][c + canMove] = true;
                }
            }

            //3. c에서 옮기기
            if (c + a <= A) {
                if (!visited[c + a][b][0]) {
                    queue.add(new Node(c + a, b, 0));
                    visited[c + a][b][0] = true;
                }

            } else {
                int canMove = A - a;
                if (!visited[a + canMove][b][c - canMove]) {
                    queue.add(new Node(a + canMove, b, c - canMove));
                    visited[a + canMove][b][c - canMove] = true;
                }

            }

            if (b + c <= B) {
                if (!visited[a][b + c][0]) {
                    queue.add(new Node(a, b + c, 0));
                    visited[a][b + c][0] = true;
                }

            } else {
                int canMove = B - b;
                if (!visited[a][b + canMove][c - canMove]) {
                    queue.add(new Node(a, b + canMove, c - canMove));
                    visited[a][b + canMove][c - canMove] = true;
                }
            }

        }

    }

    private static class Node {
        private int a;
        private int b;
        private int c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
