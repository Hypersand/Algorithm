import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] map;
    private static int cnt = 0;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (map[N][N] == 1) {
            System.out.println(0);
            return;
        }

        bfs();
        System.out.println(cnt);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        //방향 1 : 가로, 2: 세로, 3: 대각선
        queue.add(new Node(1, 2, 1));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int now_x = node.x;
            int now_y = node.y;
            if (now_x == N && now_y == N) {
                cnt++;
                continue;
            }

            if (node.direction == 1) {
                //가로 or 대각선
                now_y = node.y + 1;
                if (now_y <= N) {
                    if (map[now_x][now_y] != 1) {
                        queue.add(new Node(now_x, now_y, 1));
                    }
                }

                now_x = node.x + 1;
                if (now_x <= N && now_y <= N) {
                    if (map[now_x][now_y] != 1 && map[now_x - 1][now_y] != 1 && map[now_x][now_y - 1] != 1) {
                        queue.add(new Node(now_x, now_y, 3));
                    }
                }


            } else if (node.direction == 2) {
                //세로 Or 대각선
                now_x = node.x + 1;
                if (now_x <= N) {
                    if (map[now_x][now_y] != 1) {
                        queue.add(new Node(now_x, now_y, 2));
                    }
                }

                now_y = node.y + 1;
                if (now_x <= N && now_y <= N) {
                    if (map[now_x][now_y] != 1 && map[now_x - 1][now_y] != 1 && map[now_x][now_y - 1] != 1) {
                        queue.add(new Node(now_x, now_y, 3));
                    }
                }

            } else {
                //가로 or 세로 or 대각선
                now_y = node.y + 1;
                if (now_y <= N) {
                    if (map[now_x][now_y] != 1) {
                        queue.add(new Node(now_x, now_y, 1));
                    }
                }

                now_x = node.x + 1;
                now_y = node.y;
                if (now_x <= N) {
                    if (map[now_x][now_y] != 1) {
                        queue.add(new Node(now_x, now_y, 2));
                    }
                }

                now_x = node.x + 1;
                now_y = node.y + 1;
                if (now_x <= N && now_y <= N) {
                    if (map[now_x][now_y] != 1 && map[now_x - 1][now_y] != 1 && map[now_x][now_y - 1] != 1) {
                        queue.add(new Node(now_x, now_y, 3));
                    }
                }
            }
        }
    }

    private static class Node {
        private int x;
        private int y;
        private int direction;
        public Node(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }
}

