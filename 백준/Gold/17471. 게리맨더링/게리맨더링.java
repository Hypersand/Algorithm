import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[] populations;
    private static List<Integer>[] lists;
    private static boolean[] isGroupA;
    private static boolean[] visited;
    private static int answer = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        populations = new int[N + 1];
        lists = new ArrayList[N + 1];
        isGroupA = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            populations[i] = Integer.parseInt(st.nextToken());
            lists[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= num; j++) {
                lists[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        comb(1);

        if (answer == 1000000000) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void comb(int idx) {
        if (idx == N + 1) {
            visited = new boolean[N + 1];
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    list.add(search(i));
                }
            }

            if (list.size() == 2) {
                answer = Math.min(Math.abs(list.get(0) - list.get(1)), answer);
            }
            return;
        }

        for (int i = 1; i <= 2; i++) {
            if (i == 1) {
                isGroupA[idx] = true;
            } else {
                isGroupA[idx] = false;
            }
            comb(idx + 1);
        }

    }

    private static int search(int node) {
        Queue<Integer> queue = new LinkedList<>();
        boolean group = isGroupA[node];
        visited[node] = true;
        queue.add(node);
        int population = populations[node];
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : lists[cur]) {
                if (isGroupA[next] == group && !visited[next]) {
                    visited[next] = true;
                    population += populations[next];
                    queue.add(next);
                }
            }
        }
        return population;
    }
}
