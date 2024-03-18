import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int r, c, k;
    private static int[][] A;
    private static int maxRow = 3;
    private static int maxCol = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        A = new int[100][100];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 100; i++) {
            if (A[r][c] == k) {
                System.out.println(i);
                return;
            }

            //R연산
            if (maxRow >= maxCol) {
                calculateR();
            }
            //C연산
            else {
                calculateC();
            }
        }

        if (A[r][c] == k) {
            System.out.println(100);
        } else {
            System.out.println(-1);
        }
    }

    private static void calculateR() {
        int newCol = 0;
        for (int i = 0; i < maxRow; i++) {
            int[] cnts = new int[101];
            for (int j = 0; j < maxCol; j++) {
                if (A[i][j] == 0) continue;
                cnts[A[i][j]]++;
            }

            List<Node> list = new ArrayList<>();
            for (int j = 1; j <= 100; j++) {
                if (cnts[j] == 0) continue;
                list.add(new Node(j, cnts[j]));
            }
            Collections.sort(list);

            //list에 저장된 수의 인덱스와 갯수를 A 배열로 옮긴다.
            int t = 0;
            for (int j = 0; j < list.size(); j++) {
                Node node = list.get(j);
                A[i][t++] = node.idx;
                A[i][t++] = node.count;

                if (t == 100) break;
            }

            newCol = Math.max(newCol, t);

            for (int j = t; j < 100; j++) {
                A[i][j] = 0;
            }
        }

        maxCol = newCol;
    }

    private static void calculateC() {
        int newRow = 0;
        for (int i = 0; i < maxCol; i++) {
            int[] cnts = new int[101];
            for (int j = 0; j < maxRow; j++) {
                if (A[j][i] == 0) continue;
                cnts[A[j][i]]++;
            }

            List<Node> list = new ArrayList<>();
            for (int j = 1; j <= 100; j++) {
                if (cnts[j] == 0) continue;
                list.add(new Node(j, cnts[j]));
            }
            Collections.sort(list);

            //list에 저장된 수의 인덱스와 갯수를 A 배열로 옮긴다.
            int t = 0;
            for (int j = 0; j < list.size(); j++) {
                Node node = list.get(j);
                A[t++][i] = node.idx;
                A[t++][i] = node.count;

                if (t == 100) break;
            }

            newRow = Math.max(newRow, t);

            for (int j = t; j < 100; j++) {
                A[j][i] = 0;
            }
        }

        maxRow = newRow;
    }

    private static class Node implements Comparable<Node>{
        private int idx;
        private int count;

        public Node(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }

        @Override
        public int compareTo(Node n) {
            if (this.count == n.count) {
                return this.idx - n.idx;
            }
            return this.count - n.count;
        }
    }
}
