import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer>[] lists;
    private static int[] inDegrees;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N + 1];
        inDegrees = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            inDegrees[b]++;
        }

        search();
        System.out.println(sb);
    }

    private static void search() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int num = pq.poll();
            sb.append(num).append(" ");
            for (int next : lists[num]) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    pq.add(next);
                }
            }
        }
    }
}
