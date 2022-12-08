

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<Integer>[] list;
    private static boolean [] visited1;
    private static boolean [] visited2;
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited1 = new boolean[N + 1];
        visited2 = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);

    }

    private static void dfs(int V) {
        visited1[V] = true;
        sb.append(V+" ");
        for(int a : list[V]) {
            if(!visited1[a]) {
                dfs(a);
            }
        }
    }
    private static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited2[V] = true;
        sb.append(V+" ");
        while(!queue.isEmpty()) {
            int b = queue.poll();
            for (int a : list[b]) {
                if (!visited2[a]) {
                    visited2[a] = true;
                    sb.append(a + " ");
                    queue.add(a);
                }
            }
        }

    }
}
