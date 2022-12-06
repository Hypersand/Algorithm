
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static ArrayList<Integer> [] list;
    private static boolean [] visited;
    private static int [] result;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        visited = new boolean[N + 1];
        result = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }


        for(int i = 1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        bfs(R);

        for(int i = 1; i<=N; i++) {
           sb.append(result[i]).append("\n");
        }

        System.out.println(sb);

    }

    private static void bfs(int R) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        visited[R] = true;
        result[R] = ++count;

        while(!queue.isEmpty()) {
            int a = queue.poll();
            Iterator<Integer> itr = list[a].listIterator();
            for(int i = 0; i<list[a].size(); i++) {
                if(itr.hasNext()) {
                    int tmp = itr.next();
                    if (!visited[tmp]) {
                        visited[tmp] = true;
                        result[tmp] = ++count;
                        queue.add(tmp);
                    }
                }
            }
        }
    }
}
