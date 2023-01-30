
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    private static int visit_y[] = new int[16];
    private static int visit_l[] = new int[33];
    private static int visit_r[] = new int[33];
    private static int N;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nQueen(0);

        System.out.println(count);
    }

    private static void nQueen(int col) {

        if (col == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit_y[i] == 0 && visit_l[col - i + N] == 0 && visit_r[col + i] == 0) {
                visit_y[i] = 1;
                visit_l[col-i+N] = 1;
                visit_r[col + i] = 1;
                nQueen(col + 1);
                visit_y[i] = 0;
                visit_l[col-i+N] = 0;
                visit_r[col + i] = 0;
            }
        }
    }
}
