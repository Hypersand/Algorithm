import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    private static int[][] arr;
    private static int R;
    private static int C;
    private static int T;
    private static List<Point> airCleaners;
    private static List<Point> dusts;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[] airDx1 = {0, -1, 0, 1}; //위쪽 공기청정기
    private static int[] airDy1 = {1, 0, -1, 0};
    private static int[] airDx2 = {0, 1, 0, -1}; //아래쪽 공기청정기
    private static int[] airDy2 = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        airCleaners = new ArrayList<>();
        dusts = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    airCleaners.add(new Point(i, j));
                } else if (arr[i][j] != 0) {
                    dusts.add(new Point(i, j));
                }
            }
        }

        for (int i = 0; i < T; i++) {
            bfs();
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) {
                    answer += arr[i][j];
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs() {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < dusts.size(); i++) {
            Point p = dusts.get(i);
            int directionCnt = 0;
            for (int j = 0; j < 4; j++) {
                int nx = p.x + dx[j];
                int ny = p.y + dy[j];
                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if (arr[nx][ny] != -1) {
                        directionCnt++;
                        String str = nx + " " + ny;
                        map.put(str, map.getOrDefault(str, 0) + arr[p.x][p.y] / 5);
                    }
                }
            }
            arr[p.x][p.y] -= directionCnt * (arr[p.x][p.y] / 5);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                String key = i + " " + j;
                if (map.containsKey(key)) {
                    arr[i][j] += map.get(key);
                }
            }
        }
        airCleanerActivate();
    }

    private static void airCleanerActivate() {
        Point start1 = airCleaners.get(0);
        int dir = 0;
        int tmp = 0;
        int cx = start1.x;
        int cy = start1.y;
        while (dir < 4) {
            int nx = cx + airDx1[dir];
            int ny = cy + airDy1[dir];
            if (nx == start1.x && ny == start1.y) break;
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                dir++;
                continue;
            }
            cx = nx;
            cy = ny;
            int tmp2 = arr[nx][ny];
            arr[nx][ny] = tmp;
            tmp = tmp2;
        }

        Point start2 = airCleaners.get(1);
        cx = start2.x;
        cy = start2.y;
        dir = 0;
        tmp = 0;
        while (dir < 4) {
            int nx = cx + airDx2[dir];
            int ny = cy + airDy2[dir];
            if (nx == start2.x && ny == start2.y) break;
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                dir++;
                continue;
            }
            cx = nx;
            cy = ny;
            int tmp2 = arr[nx][ny];
            arr[nx][ny] = tmp;
            tmp = tmp2;
        }

        dusts.clear();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) {
                    dusts.add(new Point(i, j));
                }
            }
        }
    }
}
