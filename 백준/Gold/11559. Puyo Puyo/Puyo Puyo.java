import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static String[][] arr = new String[12][6];
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            arr[i] = br.readLine().split("");
        }

        game();
        System.out.println(answer);
    }

    private static List<Point> bfs(int x, int y, String color) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[12][6];
        List<Point> list = new ArrayList<>();
        queue.add(new Point(x, y));
        list.add(new Point(x, y));
        visited[x][y] = true;
        int cnt = 1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
                if (visited[nx][ny] || !arr[nx][ny].equals(color)) continue;
                queue.add(new Point(nx, ny));
                list.add(new Point(nx, ny));
                visited[nx][ny] = true;
                cnt++;
            }
        }

        if (cnt >= 4) {
            return list;
        }
        return null;
    }

    private static void game() {
        int cnt = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (!arr[i][j].equals(".")) {
                    //null이 아니면 연쇄가 일어난다.
                    List<Point> list = bfs(i, j, arr[i][j]);
                    if (list != null) {
                        cnt++;
                        for (Point p : list) {
                            arr[p.x][p.y] = ".";
                        }
                    }
                }
            }
        }
        if (cnt == 0) {
            return;
        }
        //중력의 영향을 받은 뿌요들을 다시 내려야된다.
        //아래에 다른 뿌요나 바닥이 나올때까지 떨어진다.
        for (int i = 10; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                //뿌요 발견
                if (!arr[i][j].equals(".")) {
                    //어디까지 내릴 수 있는지 찾기
                    int idx = i;
                    for (int k = i + 1; k < 12; k++) {
                        //뿌요를 만나면 반복문 탈출
                        if (!arr[k][j].equals(".")) {
                            idx = k - 1;
                            break;
                        } else {
                            idx = k;
                        }
                    }
                    if (idx == i) continue;
                    String color = arr[i][j];
                    arr[idx][j] = color;
                    arr[i][j] = ".";
                }
            }
        }

        answer++;
        game();
    }

}
