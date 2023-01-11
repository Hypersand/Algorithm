
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [][] arr = new int[N+1][N+1];
        arr[0][0] = 1;

        if (K < 0) {
            System.out.println(0);
            return;
        }
        if (N < K) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    arr[i][j] = 1;
                }
                else {
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j])%10007;
                }
            }
        }
        System.out.println(arr[N][K]);

    }

}
