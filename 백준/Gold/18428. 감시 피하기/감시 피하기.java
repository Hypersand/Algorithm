import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static String[][] map;
    private static boolean[][] isBlocked;
    private static List<Point> teachers = new ArrayList<>();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        isBlocked = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken();
                if (map[i][j].equals("T")) {
                    teachers.add(new Point(i, j));
                }
            }
        }

        comb(0, 0, 0);
        System.out.println("NO");
    }

    private static void comb(int x, int y, int cnt) {
        if (cnt == 3) {
            //모든 학생들을 감시로부터 피할 수 있는지 검사
            if (validate()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = y; j < N; j++) {
                if (map[i][j].equals("X") && !isBlocked[i][j]) {
                    isBlocked[i][j] = true;
                    comb(x, y, cnt + 1);
                    isBlocked[i][j] = false;
                }
            }
        }
    }

    private static boolean validate() {
        for (Point teacher : teachers) {
            int nx = teacher.x;
            int ny = teacher.y;
            int idx = 0;
            while (idx < 4) {
                nx += dx[idx];
                ny += dy[idx];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || isBlocked[nx][ny]) {
                    nx = teacher.x;
                    ny = teacher.y;
                    idx++;
                    continue;
                }
                if (map[nx][ny].equals("S")) {
                    return false;
                }
            }
        }

        return true;
    }
}
