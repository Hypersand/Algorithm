import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int H, W;
    private static int[][] map;
    private static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int h = Integer.parseInt(st.nextToken());
            for (int j = H - 1; j >= H - h; j--) {
                map[j][i] = 1;
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 0) {
                    findWall(i, j);
                }
            }
        }
        System.out.println(result);
    }

    private static void findWall(int row, int col) {
        boolean isLeftWall = false;
        boolean isRightWall = false;
        for (int i = 0; i < col; i++) {
            if (map[row][i] == 1) {
                isLeftWall = true;
            }
        }

        for (int i = col; i < W; i++) {
            if (map[row][i] == 1) {
                isRightWall = true;
            }
        }

        if (isLeftWall && isRightWall) {
            result++;
        }
    }
}
