
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int [][] arr;
    private static int zero = 0;
    private static int minusOne = 0;
    private static int One = 0;


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
        DAC(N, 0, 0);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(One);
    }

    private static void DAC(int length, int row, int col) {
        if (length == 1) {
            if(arr[row][col]==0) {
                zero++;
            }
            else if (arr[row][col]==-1) {
                minusOne++;
            }
            else {
                One++;
            }
        }
        else {
            int start = arr[row][col];
            for (int i = row; i < row + length; i++) {
                for (int j = col; j < col + length; j++) {
                    if (start != arr[i][j]) {
                        for (int k = 0; k < 3; k++) {
                            for (int t = 0; t < 3; t++) {
                                DAC(length / 3, row+length/3 * k, col+length/3 * t);
                            }
                        }
                        return;
                    }
                }
            }
            if (start == 0) {
                zero++;
            }
            else if (start == 1) {
                One++;
            }
            else {
                minusOne++;
            }
        }
    }
}
