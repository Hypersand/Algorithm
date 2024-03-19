import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, T;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //원판을 T번 회전시킨다.
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            //번호가 x의 배수인 원판을 d방향으로 k칸 회전시킨다
            for (int j = x; j <= N; j += x) {
                rotate(j, d, k);
            }

            //원판에 남은 수 조사
            validate();
        }


        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                answer += arr[i][j];
            }
        }

        System.out.println(answer);
    }

    private static void rotate(int idx, int d, int k) {
        //시계방향 회전
        if (d == 0) {
            //k칸 회전
            for (int i = 0; i < k; i++) {
                int tmp = arr[idx][M];
                for (int j = M; j > 1; j--) {
                    arr[idx][j] = arr[idx][j - 1];
                }
                arr[idx][1] = tmp;
            }
        }

        //반시계방향 회전
        if (d == 1) {
            //k칸 회전
            for (int i = 0; i < k; i++) {
                int tmp = arr[idx][1];
                for (int j = 1; j < M; j++) {
                    arr[idx][j] = arr[idx][j + 1];
                }
                arr[idx][M] = tmp;
            }
        }
    }

    private static void validate() {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i][j] != 0) {
                    cnt++;
                }
                if (cnt > 0) {
                    break;
                }
            }
        }

        if (cnt == 0) {
            return;
        }

        //원판에 수가 남아 있으면, 인접하면서 수가 같은 것을 모두 찾고 지운다.
        visited = new boolean[N + 1][M + 1];
        boolean isClosed = false;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!visited[i][j] && arr[i][j] != 0) {
                    if (bfs(i, j) > 0) {
                        isClosed = true;
                    }
                }
            }
        }

        //인접한 수가 없으면, 원판에 적힌 수의 평균을 구하고 평균보다 큰 수에는 1을 빼고 작은 수에는 1을 더한다.
        if (!isClosed) {
            int sum = 0;
            int cnt2 = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    sum += arr[i][j];
                    if (arr[i][j] > 0) cnt2++;
                }
            }

            double mid = (double) (sum) / cnt2;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (arr[i][j] > mid) {
                        arr[i][j] -= 1;
                        continue;
                    }

                    if (arr[i][j] < mid && arr[i][j] != 0) {
                        arr[i][j] += 1;
                    }
                }
            }
        }


    }

    private static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        int target = arr[x][y];
        int cnt = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.y == 1) {
                if (arr[p.x][M] == target && !visited[p.x][M]) {
                    cnt++;
                    arr[p.x][M] = 0;
                    queue.add(new Point(p.x, M));
                    visited[p.x][M] = true;
                }
            }

            if (p.y == M) {
                if (arr[p.x][1] == target && !visited[p.x][1]) {
                    cnt++;
                    arr[p.x][1] = 0;
                    queue.add(new Point(p.x, 1));
                    visited[p.x][1] = true;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || ny < 0 || nx > N || ny > M) continue;
                if (visited[nx][ny]) continue;
                if (arr[nx][ny] != target) continue;
                cnt++;
                arr[nx][ny] = 0;
                queue.add(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }

        if (cnt > 0) {
            arr[x][y] = 0;
            return cnt;
        }

        return 0;
    }
}
