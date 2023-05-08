
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int minHeight;
    private static int maxHeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        minHeight = 256;
        maxHeight = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(map[i][j], minHeight);
                maxHeight = Math.max(map[i][j], maxHeight);
            }
        }

        int minSec = Integer.MAX_VALUE;
        int ansHeight = 0;

        for (int height = minHeight; height <= maxHeight; height++) {

            int inventory = B;
            int sec = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (height == map[i][j]) {
                        continue;
                    }

                    int tmp = Math.abs(map[i][j] - height);

                    if (height < map[i][j]) {
                        sec += tmp * 2;
                        inventory += tmp;
                        continue;
                    }

                    // height > map[i][j]
                    inventory -= tmp;
                    sec += tmp;
                }
            }

            if (inventory < 0) {
                continue;
            }

            if (sec == minSec) {
                ansHeight = Math.max(height, ansHeight);
            }

            if (sec < minSec) {
                minSec = sec;
                ansHeight = height;
            }
        }

        System.out.println(minSec + " " + ansHeight);


    }

}
