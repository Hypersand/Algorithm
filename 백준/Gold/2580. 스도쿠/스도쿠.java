import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0);
    }

    private static void backTracking(int row, int col) {
        if (col == 9) {
            backTracking(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (map[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (validateNum(row, col, i)) {
                    map[row][col] = i;
                    backTracking(row, col + 1);
                    map[row][col] = 0;
                }
            }
        } else {
            backTracking(row, col + 1);
        }
    }

    private static boolean validateNum(int row, int col, int num) {
        // 행 검증
        for (int i = 0; i < 9; i++) {
            if (i == col) continue;
            if (map[row][i] == num) return false;
        }

        // 열 검증
        for (int i = 0; i < 9; i++) {
            if (i == row) continue;
            if (map[i][col] == num) return false;
        }

        // 3x3 사각형 검증 -> 사각형 시작 지점을 찾아야 함.
        int start_row = row / 3;
        int start_col = col / 3;
        start_row *= 3;
        start_col *= 3;

        for (int i = start_row; i < start_row + 3; i++) {
            for (int j = start_col; j < start_col + 3; j++) {
                if (i == row && j == col) continue;
                if (map[i][j] == num) return false;
            }
        }

        return true;
    }
}

