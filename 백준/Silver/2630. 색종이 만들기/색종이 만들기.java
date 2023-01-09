
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int [][] arr;
    private static int whiteCount = 0;
    private static int blueCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DAC(N, 0,0);

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    private static void DAC(int length, int row, int col) {
        if (length == 1) {
            if (arr[row][col] == 0) {
                whiteCount++;
                return;
            }
            else {
                blueCount++;
                return;
            }
        }

        int sum = 0;
        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                sum += arr[i][j];
            }
        }
        if (sum == 0) {
            whiteCount++;
        }
        else if (sum == length*length) {
            blueCount++;
        }
        else {
            DAC(length / 2, row, col);
            DAC(length / 2, row+length/2, col);
            DAC(length / 2, row, col+length/2);
            DAC(length / 2, row+length/2, col+length/2);
        }

    }
}
