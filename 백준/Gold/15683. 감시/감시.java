import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int ans = 0;
    private static int[][][] mode = {{{0}}, {{0}, {1}, {2}, {3}}, {{2, 3}, {0, 1}},
            {{0, 3}, {1, 3}, {1, 2}, {0, 2}},
            {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},
            {{0, 1, 2, 3}}};
    private static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                //cctv list에 담기
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    list.add(new Node(i, j, map[i][j]));
                } else if (map[i][j] == 0) {
                    ans++;
                }
            }
        }

        if (list.size() > 0) {
            selectDirection(0, list.size(), map);
        }
        System.out.println(ans);

    }

    private static void selectDirection(int idx, int maxIdx, int[][] map) {
        if (idx == maxIdx) {
            int cnt = calculate(map);
            ans = Math.min(cnt, ans);
            return;
        }

        int x = list.get(idx).x;
        int y = list.get(idx).y;
        int type = list.get(idx).type;

        for (int i = 0; i < mode[type].length; i++) {
            int[][] copyMap = new int[map.length][map[0].length];
            for (int j = 0; j < map.length; j++) {
                copyMap[j] = map[j].clone();
            }

            for (int j = 0; j < mode[type][i].length; j++) {
                int dir = mode[type][i][j];
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                while (true) {
                    if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) break;
                    if (copyMap[nx][ny] == 6) break;
                    copyMap[nx][ny] = -1;
                    nx += dx[dir];
                    ny += dy[dir];
                }
            }
            selectDirection(idx + 1, maxIdx, copyMap);

        }
    }

    private static int calculate(int[][] copyMap) {
        int cnt = 0;
        for (int i = 0; i < copyMap.length; i++) {
            for (int j = 0; j < copyMap[i].length; j++) {
                if (copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static class Node {
        int x;
        int y;
        int type;

        public Node(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }


}
