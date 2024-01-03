import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    private static int N;
    private static int[][] arr;
    private static List<Integer>[] lists;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        lists = new ArrayList[N * N + 1];
        for (int i = 1; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        List<Integer> orderList = new ArrayList<>();
        for (int i = 1; i < lists.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            orderList.add(num);
            //각각의 학생이 좋아하는 학생 4명 리스트에 담기
            for (int j = 0; j < 4; j++) {
                lists[num].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int node : orderList) {
            search(node);
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int node = arr[i][j];
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >=N || ny >= N) continue;
                    if (lists[node].contains(arr[nx][ny])) {
                        cnt++;
                    }
                }
                if (cnt == 1) {
                    answer += 1;
                    continue;
                }
                if (cnt == 2) {
                    answer += 10;
                    continue;
                }
                if (cnt == 3) {
                    answer += 100;
                    continue;
                }
                if (cnt == 4) {
                    answer += 1000;
                }
            }
        }

        System.out.println(answer);
    }

    private static void search(int node) {
        int maxCnt = 0;
        List<Point> positions = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //비어있는 칸이라면?
                if (arr[i][j] == 0) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        //비어있는 칸과 인접한 칸 중 node가 좋아하는 학생이 몇명있는지 카운트한다.
                        if (lists[node].contains(arr[nx][ny])) {
                            cnt++;
                        }
                    }
                    if (cnt > maxCnt) {
                        maxCnt = cnt;
                        positions.clear();
                        positions.add(new Point(i, j));
                        continue;
                    }

                    if (cnt == maxCnt) {
                        positions.add(new Point(i, j));
                    }

                    //cnt < maxCnt이면 해당 자리는 제외

                }
            }
        }

        if (positions.size() == 1) {
            Point p = positions.get(0);
            arr[p.x][p.y] = node;
            return;
        }

        //1을 만족하는 경우가 여러 개 -> 인접한 칸 중 비어있는 칸이 가장 많은 칸으로 자리를 정한다
        List<Point> newPositions = new ArrayList<>();
        maxCnt = 0;
        for (Point p : positions) {
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (arr[nx][ny] == 0) cnt++;
            }
            if (cnt > maxCnt) {
                maxCnt = cnt;
                newPositions.clear();
                newPositions.add(new Point(p.x, p.y));
                continue;
            }
            if (cnt == maxCnt) {
                newPositions.add(new Point(p.x, p.y));
            }
        }

        if (newPositions.size() == 1) {
            Point p = newPositions.get(0);
            arr[p.x][p.y] = node;
            return;
        }

        Collections.sort(newPositions, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.x == p2.x) {
                    return p1.y - p2.y;
                }
                return p1.x - p2.x;
            }
        });

        Point p = newPositions.get(0);
        arr[p.x][p.y] = node;
    }
}
