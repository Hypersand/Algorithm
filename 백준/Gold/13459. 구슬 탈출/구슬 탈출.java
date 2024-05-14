import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static char[][] map;
    private static int[] dx = {-1, 1, 0, 0}; // 북 남 서 동
    private static int[] dy = {0, 0, -1, 1};
    private static Point red;
    private static Point blue;
    private static Point goal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 79) {
                    goal = new Point(i, j);
                    break;
                }
            }
        }

        selectDirection(0);
        System.out.println(0);
    }

    private static void selectDirection(int cnt) {
        if (cnt == 10) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            FourMarble fourMarble = validateDirection(i);
            selectDirection(cnt + 1);
            map[fourMarble.newRed.x][fourMarble.newRed.y] = '.';
            map[fourMarble.newBlue.x][fourMarble.newBlue.y] = '.';
            map[fourMarble.originRed.x][fourMarble.originRed.y] = 'R';
            map[fourMarble.originBlue.x][fourMarble.originBlue.y] = 'B';
        }
    }

    private static FourMarble validateDirection(int dir) {
        Point redPos = new Point(0, 0);
        Point bluePos = new Point(0, 0);

        // 빨간 구슬, 파란 구슬 위치 조회
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'R') {
                    redPos = new Point(i, j);
                    red = new Point(i, j);
                    continue;
                }
                if (map[i][j] == 'B') {
                    bluePos = new Point(i, j);
                    blue = new Point(i, j);
                }
            }
        }

        dfs(redPos.x, redPos.y, bluePos.x, bluePos.y, dir, false, false);
        map[redPos.x][redPos.y] = '.';
        map[bluePos.x][bluePos.y] = '.';
        map[red.x][red.y] = 'R';
        map[blue.x][blue.y] = 'B';
        return new FourMarble(redPos, bluePos, new Point(red.x, red.y), new Point(blue.x, blue.y));
    }

    private static void dfs(int redX, int redY, int blueX, int blueY, int dir, boolean redHole, boolean blueHole) {
        int newRedX = redX + dx[dir];
        int newRedY = redY + dy[dir];
        int newBlueX = blueX + dx[dir];
        int newBlueY = blueY + dy[dir];

        if (isOutOfBounds(newRedX, newRedY) || map[newRedX][newRedY] == '#') {
            newRedX = redX;
            newRedY = redY;
        }

        if (isOutOfBounds(newBlueX, newBlueY) || map[newBlueX][newBlueY] == '#') {
            newBlueX = blueX;
            newBlueY = blueY;
        }

        if (redX == goal.x && redY == goal.y) {
            newRedX = redX;
            newRedY = redY;
        }

        if (blueX == goal.x && blueY == goal.y) {
            newBlueX = blueX;
            newBlueY = blueY;
        }

        // 빨강의 이동 방향에 파랑이 있다면(파랑은 움직이지 않은 상태여야 함) 움직이지 않는다.
        if (blueX == newBlueX && blueY == newBlueY) {
            if (newRedX == newBlueX && newRedY == newBlueY) {
                if (newRedX != goal.x || newRedY != goal.y) {
                    newRedX = redX;
                    newRedY = redY;
                }
            }
        }
        // 파랑의 이동 방향에 빨강이 있다면(빨강은 움직이지 않은 상태여야 함) 움직이지 않는다.
        else if (redX == newRedX && redY == newRedY) {
            if (newRedX == newBlueX && newRedY == newBlueY) {
                if (newBlueX != goal.x || newBlueY != goal.y) {
                    newBlueX = blueX;
                    newBlueY = blueY;
                }
            }
        }

        if (newRedX == goal.x && newRedY == goal.y) {
            redHole = true;
        }

        if (newBlueX == goal.x && newBlueY == goal.y) {
            blueHole = true;
        }

        // 둘다 움직이지 않았다면?
        if (redX == newRedX && redY == newRedY && blueX == newBlueX && blueY == newBlueY) {
            if (redHole && !blueHole) {
                System.out.println(1);
                System.exit(0);
            }
            return;
        }

        red = new Point(newRedX, newRedY);
        blue = new Point(newBlueX, newBlueY);
        dfs(newRedX, newRedY, newBlueX, newBlueY, dir, redHole, blueHole);
    }

    private static boolean isOutOfBounds(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }

    private static class FourMarble {
        private Point originRed;
        private Point originBlue;
        private Point newRed;
        private Point newBlue;

        public FourMarble(Point originRed, Point originBlue, Point newRed, Point newBlue) {
            this.originRed = originRed;
            this.originBlue = originBlue;
            this.newRed = newRed;
            this.newBlue = newBlue;
        }
    }

}
