import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[] populations;
    private static List<Integer>[] lists;
    private static int[] group;
    private static int min = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        populations = new int[N + 1];
        lists = new ArrayList[N + 1];
        group = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            populations[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int u = Integer.parseInt(st.nextToken());
                lists[i].add(u);
            }
        }

        divide(1);

        if (min == 10000000) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static void divide(int idx) {
        if (idx == N + 1) {
            //2개의 그룹으로 나눴으면 각 그룹 검증
            boolean[] visited = new boolean[N + 1];
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    int pops = bfs(visited, i);
                    list.add(pops);
                }
            }

            //cnt가 2이면 두 개의 그룹으로 나누어짐
            if (list.size() == 2) {
                min = Math.min(Math.abs(list.get(0) - list.get(1)), min);
            }
            return;
        }

        for (int i = 1; i <= 2; i++) {
            group[idx] = i;
            divide(idx + 1);
        }
    }

    private static int bfs(boolean[] visited, int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;
        int groupNum = group[num];
        int pops = populations[num];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : lists[node]) {
                if (!visited[next] && group[next] == groupNum) {
                    queue.add(next);
                    visited[next] = true;
                    pops += populations[next];
                }
            }
        }
        return pops;
    }
}
