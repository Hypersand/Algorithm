import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                pq.add(map[i][j]);
                if (pq.size() == N) {
                    int tmp = pq.poll();
                    max = Math.max(tmp, max);
                }

            }
        }
        System.out.println(max);
    }
}
