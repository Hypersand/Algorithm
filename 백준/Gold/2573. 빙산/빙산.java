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
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        boolean isOverTwoGrounds = false;
        while (true) {
            visited = new boolean[N][M];
            int groundCnt = iceMelting();
            year++;
            if (groundCnt >= 2) {
                isOverTwoGrounds = true;
                break;
            }
            if (groundCnt == 0) {
                break;
            }
        }

        if (isOverTwoGrounds) {
            System.out.println(year);
        } else {
            System.out.println(0);
        }
    }
    private static int iceMelting() {
        List<Ice> meltingList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //0이 아니라면 인접한 네 방향 탐색
                if (arr[i][j] != 0) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (isOutOfArray(nx, ny)) continue;
                        if (arr[nx][ny] == 0) {
                            cnt++;
                        }
                    }
                    if (cnt > 0) {
                        meltingList.add(new Ice(i, j, cnt));
                    }
                }
            }
        }

        for (Ice ice : meltingList) {
            arr[ice.x][ice.y] -= ice.meltingSize;
            if (arr[ice.x][ice.y] < 0) {
                arr[ice.x][ice.y] = 0;
            }
        }

        int groundCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] > 0 && !visited[i][j]) {
                    dfs(i, j);
                    groundCnt++;
                }
            }
        }
        return groundCnt;
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isOutOfArray(nx, ny)) continue;
            if (arr[nx][ny] == 0 || visited[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }

    private static boolean isOutOfArray(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= M;
    }

    private static class Ice {
        int x;
        int y;
        int meltingSize;

        public Ice(int x, int y, int meltingSize) {
            this.x = x;
            this.y = y;
            this.meltingSize = meltingSize;
        }
    }

}
