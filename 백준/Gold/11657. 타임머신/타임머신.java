

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static long[] dist;
    public static bus[] buses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dist = new long[N+1];
        buses = new bus[M + 1];

        Arrays.fill(dist, Long.MAX_VALUE);

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            long C = Long.parseLong(st.nextToken());
            buses[i] = new bus(A, B, C);
        }

        if (bellmanFord(N, M)) {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == Long.MAX_VALUE) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(dist[i]).append("\n");
                }
            }
        }

        else {
            sb.append(-1);
        }

        System.out.println(sb);

    }

    public static boolean bellmanFord(int N, int M) {

        dist[1] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= M; j++) {
                bus bus = buses[j];

                if (dist[bus.from] != Long.MAX_VALUE && dist[bus.to] > dist[bus.from] + bus.time) {
                    dist[bus.to] = dist[bus.from] + bus.time;
                }
            }
        }

        for (int i = 1; i <= M; i++) {
            bus bus = buses[i];

            if (dist[bus.from] != Long.MAX_VALUE && dist[bus.to] > dist[bus.from] + bus.time) {
                return false;
            }
        }

        return true;
    }

    public static class bus {
        int from;
        int to;
        long time;

        public bus(int from, int to, long time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }
}
