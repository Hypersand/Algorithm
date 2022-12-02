
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int result[] = new int[100001];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        LinkedList<Integer>[] graph = new LinkedList[N+1];
        for(int i = 1; i<=N; i++) {
            graph[i] = new LinkedList<>();
        }
        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        boolean[] visited = new boolean[N + 1];
        dfs1(R, graph, visited);

        for(int i = 1; i<=N; i++) {
            sb.append(result[i] + "\n");
        }
        System.out.println(sb);

    }

    public static void dfs1(int R, LinkedList<Integer>[] graph, boolean [] visited) {
        Iterator<Integer> iter = graph[R].listIterator();

        visited[R] = true;
        result[R] = ++count;

        while (iter.hasNext()) {
            int w = iter.next();
            if (!visited[w]) {
                dfs1(w, graph, visited);
            }
        }
    }



}
