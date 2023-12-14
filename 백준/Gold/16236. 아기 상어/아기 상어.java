
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    private static int N;
    private static int[][] arr;
    private static List<Point> fishes;
    private static Point curPos;
    private static int size = 2;
    private static int second = 0;
    private static int eatingCnt = 0;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        fishes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] >= 1 && arr[i][j] <= 6) {
                    fishes.add(new Point(i, j));
                    continue;
                }
                if (arr[i][j] == 9) {
                    curPos = new Point(i, j);
                }
            }
        }

        move();
        System.out.println(second);
    }

    private static void move() {

        //남은 물고기가 한마리 이상이라면 가장 가까운 물고기를 찾는다.
        int i = fishes.size();
        while (i > 0) {
            calculateDistanceAndEat();
            i--;
        }
    }

    private static void calculateDistanceAndEat() {
        boolean[][] visited = new boolean[N][N];
        int[][] map = new int[N][N];
        Queue<Point> queue = new LinkedList<>();
        queue.add(curPos);
        visited[curPos.x][curPos.y] = true;
        int minDistance = Integer.MAX_VALUE;
        int eatFish_x = 0;
        int eatFish_y = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || arr[nx][ny] > size) continue;
                visited[nx][ny] = true;
                map[nx][ny] = map[p.x][p.y] + 1;
                //잡아먹을 수 있는 물고기라면 체크
                if (arr[nx][ny] >= 1 && arr[nx][ny] < size) {
                    //현재까지의 최소거리보다 거리가 멀다면 패스
                    if (map[nx][ny] > minDistance) continue;
                    //최소거리와 해당 물고기까지의 거리가 같을때
                    if (map[nx][ny] == minDistance) {
                        //만약 더 아래에 있다면 패스
                        if (eatFish_x < nx) continue;
                        //행이 똑같은데 더 오른쪽에 있다면 패스
                        if (eatFish_x == nx && eatFish_y <= ny) continue;
                    }
                    minDistance = map[nx][ny];
                    eatFish_x = nx;
                    eatFish_y = ny;
                }
                queue.add(new Point(nx, ny));
            }
        }
        if (minDistance == Integer.MAX_VALUE) return;
        //가까운 물고리를 찾았다면 먹으러 간다.
        arr[curPos.x][curPos.y] = 0;
        curPos.x = eatFish_x;
        curPos.y = eatFish_y;
        //먹은 횟수 증가
        eatingCnt++;
        //사이즈와 먹은 횟수가 같다면 먹은 횟수 초기화 및 사이즈 1 증가
        if (eatingCnt == size) {
            eatingCnt = 0;
            size++;
        }
        //이동한만큼 시간 증가
        second += minDistance;
        //좌표상에서 물고기 제거
        arr[eatFish_x][eatFish_y] = 9;
    }
}
