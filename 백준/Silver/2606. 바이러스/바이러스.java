
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static ArrayList[] list;
    private static boolean [] visited;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int R = 1;
        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }
        dfs(1);

        System.out.println(count-1);
    }

    private static void dfs(int R) {
        Iterator<Integer> itr = list[R].listIterator();
        visited[R] = true;
        count++;
        
        while(itr.hasNext()) {
            int a = itr.next();
            if(!visited[a]) {
                dfs(a);
            }
        }
    }
}
