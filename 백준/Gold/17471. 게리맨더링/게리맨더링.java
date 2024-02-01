import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[] populations;
    private static List<Integer>[] lists;
    private static int[] groups;
    private static final int INF = 1000000000;
    private static int answer = INF;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        populations = new int[N + 1];
        lists = new ArrayList[N + 1];
        groups = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            populations[i] = Integer.parseInt(st.nextToken());
            lists[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            for (int j = 0; j < c; j++) {
                int node = Integer.parseInt(st.nextToken());
                lists[i].add(node);
                lists[node].add(i);
            }
        }

        for (int i = 1; i <= N / 2; i++) {
            comb(1, 0, i);
        }

        if (answer == INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void comb(int idx, int cnt, int maxCnt) {
        if (cnt == maxCnt) {
            boolean[] visited = new boolean[N + 1];
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    list.add(bfs(i, visited));
                }
            }

            if (list.size() == 2) {
                answer = Math.min(answer, Math.abs(list.get(0) - list.get(1)));
            }
            return;
        }


        for (int i = idx; i <= N; i++) {
            groups[i] = 1;
            comb(i + 1, cnt + 1, maxCnt);
            groups[i] = 0;
        }




    }

    private static int bfs(int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int groupNum = groups[start];
        int population = populations[start];
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : lists[cur]) {
                if (!visited[next] && groups[next] == groupNum) {
                    visited[next] = true;
                    queue.add(next);
                    population += populations[next];
                }
            }
        }

        return population;
    }
}
