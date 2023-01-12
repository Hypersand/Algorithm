
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A_N = Integer.parseInt(st.nextToken());
        int A_M = Integer.parseInt(st.nextToken());
        int[][] arr1 = new int[A_N][A_M];
        for (int i = 0; i < A_N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < A_M; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int B_N = Integer.parseInt(st.nextToken());
        int B_M = Integer.parseInt(st.nextToken());
        int[][] arr2 = new int[B_N][B_M];
        for (int i = 0; i < B_N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < B_M; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] arr3 = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    arr3[i][j] += arr1[i][k] * arr2[k][j];
                }
                sb.append(arr3[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
