import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    private static int N;
    private static int M;
    private static int[][] arr;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int answer = Integer.MAX_VALUE;
    private static boolean[] visited;
    private static List<Point> virusList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    virusList.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[virusList.size()];
        comb(0, 0);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void comb(int cnt, int idx) {
        if (cnt == M) {
            bfs();
            return;
        }

        for (int i = idx; i < virusList.size(); i++) {
            visited[i] = true;
            comb(cnt+1, i + 1);
            visited[i] = false;
        }
    }

    private static void bfs() {
        int[][] copyArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            copyArr[i] = arr[i].clone();
        }

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                queue.add(virusList.get(i));
            } else {
                Point p = virusList.get(i);
                copyArr[p.x][p.y] = 0;
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (copyArr[nx][ny] == 1 || copyArr[nx][ny] >= 2) continue;
                queue.add(new Point(nx, ny));
                copyArr[nx][ny] = copyArr[p.x][p.y] + 1;
            }
        }

        int seconds = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copyArr[i][j] == 0) {
                    return;
                }

                if (copyArr[i][j] > 2) {
                    seconds = Math.max(seconds, copyArr[i][j] - 2);
                }
            }
        }
        
        answer = Math.min(answer, seconds);
    }
}
