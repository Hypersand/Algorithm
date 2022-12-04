

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int [] result = new int[100001];
    private static int count = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());


        LinkedList<Integer>[] graph = new LinkedList[N+1];

        for(int i = 1; i<=N; i++) {
            graph[i] = new LinkedList();
        }

        for(int i = 1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i<=N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        boolean [] visited = new boolean[N+1];
        dfs2(R, graph, visited);

        for(int i = 1; i<=N; i++) {
            System.out.println(result[i]);
        }

    }

    private static void dfs2(int R, LinkedList<Integer>[] graph, boolean [] visited ) {
        Iterator<Integer> itr = graph[R].listIterator();

        visited[R] = true;
        result[R] = ++count;

        while(itr.hasNext()) {
            int a = itr.next();
            if(!visited[a]) {
                dfs2(a, graph, visited);
            }
        }



    }
}
