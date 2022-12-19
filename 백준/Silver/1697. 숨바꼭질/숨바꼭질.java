
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int [] dx = {-1,1,2};
    private static int [] arr = new int [100001];
    private static boolean [] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(bfs(N,K));
    }

    private static int bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;
        int count = 0;

        if(N==K) {
            return 0;
        }

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i = 0; i < 3; i++) {
                int nx = 0;
                if(i<2) {
                    nx = tmp + dx[i];
                }
                else {
                    nx = tmp*dx[2];
                }
                if(nx>=0 && nx < arr.length && !visited[nx]) {
                    arr[nx] = arr[tmp] + 1;
                    visited[nx] = true;
                    queue.add(nx);
                    if(nx==K) {
                        return arr[nx];
                    }
                }
            }

        }
        return arr[K];
    }
}
