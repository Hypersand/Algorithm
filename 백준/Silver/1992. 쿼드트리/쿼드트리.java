

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static String [][] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new String[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }

        DAC(N,0,0);

        System.out.println(sb);
    }

    private static void DAC(int length, int row, int col) {
        if (length == 1) {
            if(arr[row][col].equals("0")) sb.append(0);
            else sb.append(1);
        }
        else {
            String start = arr[row][col];
            for (int i = row; i < row+length; i++) {
                for (int j = col; j < col+length; j++) {
                    if (!arr[i][j].equals(start)) {
                        start = arr[i][j];
                        sb.append("(");
                        DAC(length / 2, row, col);
                        DAC(length / 2, row, col + length/2);
                        DAC(length / 2, row + length / 2, col);
                        DAC(length / 2, row + length / 2, col + length / 2);
                        sb.append(")");
                        return;
                    }
                }
            }
            if(start.equals("0")) sb.append("0");
            else sb.append("1");
        }
    }
}
