import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int answer = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (find(a) != find(b)) {
                union(a, b);
                continue;
            }
            //find가 동일하면 사이클 발생 -> 사이클이 발생한 차례 출력
            System.out.println(i);
            System.exit(0);
        }
        System.out.println(answer);
    }

    private static void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if (pA < pB) {
            parents[pB] = pA;
        } else {
            parents[pA] = pB;
        }
    }

    private static int find(int node) {
        if (parents[node] == node) {
            return node;
        }

        return parents[node] = find(parents[node]);
    }
}
