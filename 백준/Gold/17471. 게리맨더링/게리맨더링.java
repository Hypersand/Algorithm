import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[] populations;
    private static List<Integer>[] lists;
    private static int[] group; //1번그룹과 2번그룹으로 구분
    private static int answer = Integer.MAX_VALUE;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lists = new ArrayList[N + 1];
        populations = new int[N + 1];
        group = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            populations[i] = Integer.parseInt(st.nextToken());
            lists[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int node = Integer.parseInt(st.nextToken());
                lists[i].add(node);
                lists[node].add(i);
            }
        }
        comb(1);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    private static void comb(int idx) {
        if (idx == N + 1) {
            visited = new boolean[N + 1];
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    list.add(bfs(i));
                }
            }

            if (list.size() == 2) {
                answer = Math.min(answer, Math.abs(list.get(0) - list.get(1)));
            }
            return;
        }

        for (int i = 1; i <= 2; i++) {
            group[idx] = i;
            comb(idx + 1);
        }
    }

    private static int bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;
        int groupNum = group[num];
        int population = populations[num];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : lists[node]) {
                if (!visited[next] && group[next] == groupNum) {
                    queue.add(next);
                    visited[next] = true;
                    population += populations[next];
                }
            }
        }
        return population;
    }



}
