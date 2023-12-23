import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int R;
    private static int C;
    private static String[][] arr;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[] words = new boolean[30];
    private static int max = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().split("");
        }
        words[arr[0][0].charAt(0) - 'A'] = true;
        backTracking(1, 0, 0);
        System.out.println(max);
    }

    private static void backTracking(int cnt, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >=R || ny >= C) continue;
            //이미 지나온 알파벳
            if (words[arr[nx][ny].charAt(0) - 'A']) continue;
            //처음 방문한 알파벳이라면 = 처음 방문하는 배열칸도 의미한다
            words[arr[nx][ny].charAt(0) - 'A'] = true;
            backTracking(cnt + 1, nx, ny);
            max = Math.max(max, cnt + 1);
            words[arr[nx][ny].charAt(0) - 'A'] = false;
        }
    }
}
