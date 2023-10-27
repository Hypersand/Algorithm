import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static int max = 0;
    public static String[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            map[i] = line.split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == N - 1) {
                    if (i == N - 1) {
                        continue;
                    } else {
                        //아랫값과 스위치
                        String tmp = map[i][j];
                        map[i][j] = map[i + 1][j];
                        map[i + 1][j] = tmp;
                        calculate();
                        map[i + 1][j] = map[i][j];
                        map[i][j] = tmp;
                    }
                } else {
                    if (i == N - 1) {
                        //오른쪽 값과 스위치
                        String tmp = map[i][j];
                        map[i][j] = map[i][j+1];
                        map[i][j+1] = tmp;
                        calculate();
                        map[i][j+1] = map[i][j];
                        map[i][j] = tmp;

                    } else {
                        //오른쪽 값, 아랫값과 스위치
                        String tmp = map[i][j];
                        map[i][j] = map[i][j+1];
                        map[i][j+1] = tmp;
                        calculate();
                        map[i][j+1] = map[i][j];
                        map[i][j] = tmp;

                        map[i][j] = map[i + 1][j];
                        map[i + 1][j] = tmp;
                        calculate();
                        map[i + 1][j] = map[i][j];
                        map[i][j] = tmp;
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static void calculate() {
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N-1; j++) {
                if (map[i][j].equals(map[i][j + 1])) {
                    cnt++;
                } else {
                    max = Math.max(cnt, max);
                    cnt = 1;
                }
            }
            max = Math.max(cnt, max);
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N-1; j++) {
                if (map[j][i].equals(map[j+1][i])) {
                    cnt++;
                } else {
                    max = Math.max(cnt, max);
                    cnt = 1;
                }
            }
            max = Math.max(cnt, max);
        }
    }

}
