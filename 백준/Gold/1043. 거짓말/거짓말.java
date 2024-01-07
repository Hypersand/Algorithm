import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        List<Integer>[] lists = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            lists[i] = new ArrayList<>();
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int person = Integer.parseInt(st.nextToken());
                lists[i].add(person);
            }
        }

        boolean[] party = new boolean[M];
        Arrays.fill(party, true);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int i = 0; i < M; i++) {
                if (!party[i]) continue;
                if (lists[i].contains(num)) {
                    party[i] = false;
                    queue.addAll(lists[i]);
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (party[i]) cnt++;
        }

        System.out.println(cnt);
    }
}
