import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] arr;
    private static int[] cities;
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        parents = new int[N + 1];
        cities = new int[M];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        for (int i = 0; i < cities.length - 1; i++) {
            if (find(cities[i]) != find(cities[i + 1])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x < y) {
            parents[y] = x;
        } else if (x > y) {
            parents[x] = y;
        }
    }

    private static int find(int num) {
        if (parents[num] == num) {
            return num;
        }
        return find(parents[num]);
    }


}
