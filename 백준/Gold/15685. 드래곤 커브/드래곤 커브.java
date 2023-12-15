import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {1, 0, -1, 0};
    private static boolean[][] visited = new boolean[101][101];
    private static int startX;
    private static int startY;
    private static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            startX = x;
            startY = y;
            list = new ArrayList<>();
            visited[x][y] = true;
            calculate(d, g);
        }

        int answer = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (i + 1 <= 100 && j + 1 <= 100) {
                    if (visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1]) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static void calculate(int dir, int g) {
        //0세대부터 g세대까지 크기 키워나가기
        for (int i = 0; i <= g; i++) {
            if (i == 0) {
                int nx = startX + dx[dir];
                int ny = startY + dy[dir];
                startX = nx;
                startY = ny;
                int nDir = 0;
                if (dir == 0) {
                    nDir = 1;
                } else if (dir == 1) {
                    nDir = 2;
                } else if (dir == 2) {
                    nDir = 3;
                }
                visited[nx][ny] = true;
                list.add(nDir);
                continue;
            }
            for (int j = list.size() - 1; j >= 0; j--) {
                //d : 우 좌 상 하 {0 1 2 3}
                int d = list.get(j);
                int nx = startX + dx[d];
                int ny = startY + dy[d];
                startX = nx;
                startY = ny;
                int nDir = 0;
                if (d == 0) {
                    nDir = 1;
                } else if (d == 1) {
                    nDir = 2;
                } else if (d == 2) {
                    nDir = 3;
                }
                visited[nx][ny] = true;
                list.add(nDir);
            }
        }
    }
}
