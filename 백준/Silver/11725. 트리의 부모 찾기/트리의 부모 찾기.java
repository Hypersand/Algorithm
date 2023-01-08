
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static boolean [] visited;
    private static List<Integer>[] list;
    private static int [] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        list = new List[N + 1];
        visited = new boolean[N + 1];
        ans = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

//        dfs(1);
        bfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(ans[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int a = queue.poll();
            for (int tmp : list[a]) {
                if (!visited[tmp]) {
                    visited[tmp] = true;
                    queue.add(tmp);
                    ans[tmp] = a;
                }
            }
        }
    }

//    private static void dfs(int start) {
//        if (!visited[start]) {
//            visited[start] = true;
//            for (int a : list[start]) {
//                if (!visited[a]) {
//                    ans[a] = start;
//                    dfs(a);
//                }
//            }
//        }
//    }
//

}
