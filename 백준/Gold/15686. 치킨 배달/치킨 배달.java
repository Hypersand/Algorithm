import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static List<Node> homeList = new ArrayList<>();
    private static List<Node> chickenList = new ArrayList<>();
    private static boolean[] selected;
    private static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    homeList.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    chickenList.add(new Node(i, j));
                }

            }
        }
        selected = new boolean[chickenList.size()];
        select(0, 0);
        System.out.println(result);
    }

    public static void select(int cnt, int idx) {
        if (cnt == M) {
            int sum = 0;
            for (int i = 0; i < homeList.size(); i++) {
                Node node = homeList.get(i);
                int tmp = calculateChickenDistance(node.x, node.y);
                sum += tmp;
            }
            result = Math.min(result, sum);
            return;
        }

        for (int i = idx; i < chickenList.size(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                select(cnt + 1, i + 1);
                selected[i] = false;
            }
        }
    }

    public static int calculateChickenDistance(int row, int col) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < chickenList.size(); i++) {
            if (selected[i]) {
                Node node = chickenList.get(i);
                int distance = Math.abs(row - node.x) + Math.abs(col - node.y);
                min = Math.min(min, distance);
                if (min == 1) {
                    return 1;
                }
            }

        }
        return min;
    }

    public static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
