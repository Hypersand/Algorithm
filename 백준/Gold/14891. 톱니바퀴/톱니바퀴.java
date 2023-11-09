import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr = new int[5][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i < 5; i++) {
            String[] str = br.readLine().split("");
            for (int j = 1; j < 9; j++) {
                arr[i][j] = Integer.parseInt(str[j-1]);
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            select(num, dir);
        }

        int result = 0;
        if (arr[1][1] == 1) {
            result += 1;
        }
        if (arr[2][1] == 1) {
            result += 2;
        }
        if (arr[3][1] == 1) {
            result += 4;
        }
        if (arr[4][1] == 1) {
            result += 8;
        }

        System.out.println(result);
    }

    private static void select(int num, int dir) {
        int[] rotated = new int[5];  // 0 : 안돌림, 1 : 시계 -1 : 반시계
        if (num == 1) {
            rotated[1] = dir;
            if (arr[1][3] != arr[2][7]) {
                rotated[2] = -rotated[1];
                if (arr[2][3] != arr[3][7]) {
                    rotated[3] = -rotated[2];
                    if (arr[3][3] != arr[4][7]) {
                        rotated[4] = -rotated[3];
                    }
                }
            }

        } else if (num == 2) {
            rotated[2] = dir;
            if (arr[1][3] != arr[2][7]) {
                rotated[1] = -rotated[2];
            }
            if (arr[2][3] != arr[3][7]) {
                rotated[3] = -rotated[2];
                if (arr[3][3] != arr[4][7]) {
                    rotated[4] = -rotated[3];
                }
            }

        } else if (num == 3) {
            rotated[3] = dir;
            if (arr[3][3] != arr[4][7]) {
                rotated[4] = -rotated[3];
            }
            if (arr[2][3] != arr[3][7]) {
                rotated[2] = -rotated[3];
                if (arr[1][3] != arr[2][7]) {
                    rotated[1] = -rotated[2];
                }
            }
        } else {
            rotated[4] = dir;
            if (arr[3][3] != arr[4][7]) {
                rotated[3] = -rotated[4];
                if (arr[2][3] != arr[3][7]) {
                    rotated[2] = -rotated[3];
                    if (arr[1][3] != arr[2][7]) {
                        rotated[1] = -rotated[2];
                    }
                }
            }
        }
        rotate(rotated);
    }

    private static void rotate(int[] rotated) {
        for (int i = 1; i < 5; i++) {
            if (rotated[i] == 1) {
                int tmp = arr[i][8];
                for (int j = 7; j >= 1; j--) {
                    arr[i][j+1] = arr[i][j];
                }
                arr[i][1] = tmp;
                continue;
            }

            if (rotated[i] == -1) {
                int tmp = arr[i][1];
                for (int j = 2; j < 9; j++) {
                    arr[i][j - 1] = arr[i][j];
                }
                arr[i][8] = tmp;
            }
        }

    }
}
