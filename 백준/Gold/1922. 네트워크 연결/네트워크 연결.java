
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    private static int [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        int[][] degrees = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            degrees[i][0] = a;
            degrees[i][1] = b;
            degrees[i][2] = c;
        }

        Arrays.sort(degrees, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        
        int sum = 0;
        for (int[] degree : degrees) {
            if (union(degree[0], degree[1])) {
                sum += degree[2];
            }
        }

        System.out.println(sum);
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) {
            return false;
        }
        else {
            arr[bRoot] = aRoot;
            return true;
        }
    }

    private static int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        else {
            return arr[x] = find(arr[x]);
        }
    }
}
