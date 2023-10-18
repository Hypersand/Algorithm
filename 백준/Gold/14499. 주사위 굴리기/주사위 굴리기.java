import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] dice = new int[6];
    private static int[][] map;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            move(Integer.parseInt(st.nextToken()));
        }

    }

    private static void move(int direction) {
        int nx = x + dx[direction - 1];
        int ny = y + dy[direction - 1];

        if (nx < 0 || ny < 0 || nx > map[0].length - 1  || ny > map.length - 1) {
            return;
        }

        //동서남북 이동
        if (direction == 1) {
            int top = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[0];
            dice[0] = top;

        } else if (direction == 2) {
            int top = dice[3];
            dice[3] = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[1];
            dice[1] = top;

        } else if (direction == 3) {
            int top = dice[3];
            dice[3] = dice[4];
            dice[4] = dice[2];
            dice[2] = dice[5];
            dice[5] = top;

        } else {
            int top = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[2];
            dice[2] = dice[4];
            dice[4] = top;
        }

        if (map[ny][nx] == 0) {
            map[ny][nx] = dice[2];
        } else {
            dice[2] = map[ny][nx];
            map[ny][nx] = 0;
        }

        System.out.println(dice[3]);
        x = nx;
        y = ny;
    }
}
