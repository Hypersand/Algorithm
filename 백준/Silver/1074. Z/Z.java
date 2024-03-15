import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);
        search(size, r, c);
        System.out.println(count);
    }

    private static void search(int size, int r, int c) {
        if (size == 1) {
            return;
        }
        //왼쪽위
        if (r < size / 2 && c < size / 2) {
            search(size / 2, r, c);
            return;
        }

        //오른쪽위
        if (r < size / 2 && c >= size / 2) {
            count += (size * size / 4);
            search(size / 2, r, c - size / 2);
            return;
        }

        //왼쪽아래
        if (r >= size / 2 && c < size / 2) {
            count += (size * size / 4) * 2;
            search(size / 2, r - size / 2, c);
            return;
        }

        //오른쪽아래
        if (r >= size / 2 && c >= size / 2) {
            count += (size * size / 4) * 3;
            search(size / 2, r - size / 2, c - size / 2);
        }
    }
}
