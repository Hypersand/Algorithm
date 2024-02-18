import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static List<Integer>[] lists;
    private static int answer = Integer.MAX_VALUE;
    private static List<Integer> answerList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            lists[A].add(B);
            lists[B].add(A);
        }

        comb(1, new ArrayList<>());
        System.out.println(answerList.get(0) + " " + answerList.get(1) + " " + answer);
    }
    //N개의 치킨집 중 2개를 선택
    private static void comb(int idx, List<Integer> chickenList) {
        if (chickenList.size() == 2) {
            int result = bfs(chickenList);
            if (result < answer) {
                answer = result;
                answerList.clear();
                answerList.add(chickenList.get(0));
                answerList.add(chickenList.get(1));
            }
            return;
        }


        for (int i = idx; i <= N; i++) {
            chickenList.add(i);
            comb(idx, chickenList);
            chickenList.remove(Integer.valueOf(i));
        }
    }

    private static int bfs(List<Integer> chickenList) {
        Queue<Integer> queue = new LinkedList<>();
        int chicken1 = chickenList.get(0);
        int chicken2 = chickenList.get(1);
        queue.add(chicken1);
        queue.add(chicken2);
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        visited[chicken1] = true;
        visited[chicken2] = true;

        //설정한 치킨집으로부터 각 건물까지의 최소 거리를 구한다.
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : lists[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    queue.add(next);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result += dist[i] * 2;
        }
        return result;
    }
}
