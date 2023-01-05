
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int [][] arr;
    private static int start = 0;
    private static int link = 0;
    private static int min = Integer.MAX_VALUE;
    private static boolean [] used;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        used = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0,0);

        System.out.println(min);
    }

    private static void backTracking(int index, int num) {
        if (index == N / 2) {
            start = 0;
            link = 0;
            for (int i = 0; i < N-1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (used[i] && used[j]) {
                        start += arr[i][j] + arr[j][i];
                    }
                    if (!used[i] && !used[j]) {
                        link += arr[i][j] + arr[j][i];
                    }
                }
            }
            min = Math.min(min, Math.abs(start - link));
            if (min == 0) {
                System.out.println(0);
                System.exit(0);
            }
            return;
        }

        for (int i = num; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                backTracking(index+1,i+1);
                used[i] = false;
            }
        }
    }
}
