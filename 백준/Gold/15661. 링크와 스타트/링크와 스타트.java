import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] map;
    private static boolean[] isStart;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <= N; i++) {
            isStart = new boolean[N];
            select(i, 0, 0);
        }

        System.out.println(min);
    }

    private static void select(int max, int cnt, int idx) {
        if (max == cnt) {
            calculate();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!isStart[i]) {
                isStart[i] = true;
                select(max, cnt + 1, i);
                isStart[i] = false;
            }
        }
    }

    private static void calculate() {
        int startSum = 0;
        int linkSum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (i==j) continue;
                if (isStart[i] && isStart[j]) {
                    startSum += map[i][j] + map[j][i];

                } else if (!isStart[i] && !isStart[j]) {
                    linkSum += map[i][j] + map[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(startSum - linkSum));
    }
}
