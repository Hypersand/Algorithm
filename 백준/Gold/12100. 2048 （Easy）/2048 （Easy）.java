import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] dx = {-1, 1, 0, 0}; //상하
    private static int[] dy = {0, 0, -1, 1}; //좌우
    private static int[][] arr;
    private static int answer = 0;
    private static boolean[][] isMerged;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                answer = Math.max(answer, arr[i][j]);
            }
        }
        backTracking(0);
        System.out.println(answer);
    }

    private static void backTracking(int depth) {
        if (depth == 5) {
            return;
        }

        int[][] copyArr = new int[N][N];
        for (int j = 0; j < N; j++) {
            copyArr[j] = arr[j].clone();
        }

        for (int i = 0; i < 4; i++) {
            moveAndMerge(i);
            backTracking(depth + 1);
            for (int j = 0; j < N; j++) {
                arr[j] = copyArr[j].clone();
            }
        }
    }

    private static void moveAndMerge(int dir) {
        isMerged = new boolean[N][N];
        //위로 이동
        if (dir == 0) {
            //세로로 탐색 (위에서 부터 탐색)
            for (int j = 0; j < N; j++) {
                for (int i = 1; i < N; i++) {
                    if (arr[i][j] != 0) {
                        move2(i, j, dir);
                    }
                }
            }
        }

        //아래로 이동
        if (dir == 1) {
            //세로로 탐색
            for (int j = 0; j < N; j++) {
                for (int i = N - 2; i >= 0; i--) {
                    if (arr[i][j] != 0) {
                        move2(i, j, dir);
                    }
                }
            }
        }

        //좌
        if (dir == 2) {
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (arr[i][j] != 0) {
                        move2(i, j, dir);
                    }
                }
            }
        }

        //우
        if (dir == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = N - 2; j >= 0; j--) {
                    if (arr[i][j] != 0) {
                        move2(i, j, dir);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(arr[i][j], max);
            }
        }
        answer = Math.max(answer, max);
    }

    private static void move2(int x, int y, int dir) {
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) return;
            if (isMerged[nx][ny]) return;
            if (arr[nx][ny] != 0) {
                //합칠 수 있는지 판별하기
                if (arr[nx][ny] == arr[x][y]) {
                    if (!isMerged[nx][ny]) {
                        isMerged[nx][ny] = true;
                        arr[nx][ny] *= 2;
                        arr[x][y] = 0;
                        x = nx;
                        y = ny;
                        return;
                    }
                } else {
                    return;
                }
            }
            arr[nx][ny] = arr[x][y];
            arr[x][y] = 0;
            x = nx;
            y = ny;
        }
    }
}
