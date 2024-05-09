import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map = {
            {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40},
            {10, 13, 16, 19, 25, 30, 35, 40},
            {20, 22, 24, 25, 30, 35, 40},
            {30, 28, 27, 26, 25, 30, 35, 40}
    };
    private static int[] diceResults = new int[10];
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            diceResults[i] = Integer.parseInt(st.nextToken());
        }

        game(0, new ArrayList<>());
        System.out.println(answer);
    }

    // diceResults에 나온 결과대로 어떤 말을 이동시킬지 백트래킹을 통해 미리 지정한다.
    private static void game(int idx, List<Integer> list) {
        if (idx == 10) {
            calculateResult(list);
            return;
        }

        // 1번말 ~ 4번말 선택
        for (int i = 1; i <= 4; i++) {
            list.add(i);
            game(idx + 1, list);
            list.remove(list.size() - 1);
        }
    }

    private static void calculateResult(List<Integer> list) {
        // 1번말부터 4번말까지의 현재 위치를 저장하는 리스트
        List<Point> positions = new ArrayList<>();
        boolean[] isArrived = new boolean[5];
        for (int i = 0; i <= 5; i++) {
            positions.add(new Point(0, 0));
        }
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            int horseNum = list.get(i); // 이동하는 말의 번호
            int moveCount = diceResults[i]; // 이동거리

            int row = positions.get(horseNum).x;
            int col = positions.get(horseNum).y;

            // 이미 목적지에 도착한 말을 움직이려고 하면? -> 아예 넘어가
            if (isArrived[horseNum]) return;

            if (row == 0) {
                col += moveCount;
                // 도착지점 도달
                if (col >= map[0].length) {
                    isArrived[horseNum] = true;
                    continue;
                }

                if (map[row][col] == 10) {
                    row = 1;
                    col = 0;
                } else if (map[row][col] == 20) {
                    row = 2;
                    col = 0;
                } else if (map[row][col] == 30) {
                    row = 3;
                    col = 0;
                }
            } else {
                col += moveCount;
                // 도착지점 도달
                if (col >= map[row].length) {
                    isArrived[horseNum] = true;
                    continue;
                }
            }

            // 이동하려는 목표 지점에 말이 하나라도 있다면 패스(도착 칸은 괜찮)
            boolean flag = true;
            for (int j = 1; j <= 4; j++) {
                if (j == horseNum) continue;
                // 22, 24, 26, 28, 30은 2곳에 있음. -> 값 뿐만 아니라 row col이 아예 같아야지 동일한 위치임.
                if (map[positions.get(j).x][positions.get(j).y] == map[row][col] && !isArrived[j]) {
                    if (map[row][col] == 22 || map[row][col] == 24 || map[row][col] == 26 || map[row][col] == 28 || map[row][col] == 30) {
                        if (positions.get(j).x == row && positions.get(j).y == col) {
                            flag = false;
                            break;
                        }
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag) return;

            // 이동하려는 목표 지점에 말이 없다면 이동한다.
            positions.set(horseNum, new Point(row, col));
            sum += map[row][col];
        }

        answer = Math.max(answer, sum);
    }
}
