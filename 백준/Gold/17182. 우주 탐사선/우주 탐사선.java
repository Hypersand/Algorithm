import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static int[][] dists;
    private static boolean[] visited;
    private static final int INF = 100000000;
    private static int answer = INF;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dists = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dists[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    if (dists[i][k] + dists[k][j] < dists[i][j]) {
                        dists[i][j] = dists[i][k] + dists[k][j];
                    }
                }
            }
        }

        visited[K] = true;
        findPlanetRoute(new ArrayList<>());
        System.out.println(answer);
    }


    private static void findPlanetRoute(List<Integer> orders) {
        if (orders.size() == N - 1) {
            int dist = dists[K][orders.get(0)];
            for (int i = 0; i < orders.size() - 1; i++) {
                dist += dists[orders.get(i)][orders.get(i + 1)];
            }
            answer = Math.min(answer, dist);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            orders.add(i);
            findPlanetRoute(orders);
            visited[i] = false;
            orders.remove(orders.size() - 1);
        }
    }
}
