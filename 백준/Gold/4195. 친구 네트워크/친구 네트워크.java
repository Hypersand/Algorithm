import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] parents;
    private static int[] cnts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int F = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            parents = new int[2 * F + 1];
            cnts = new int[2 * F + 1];
            int idx = 1;
            for (int j = 0; j < F; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String friend1 = st.nextToken();
                String friend2 = st.nextToken();
                if (!map.containsKey(friend1)) {
                    parents[idx] = idx;
                    cnts[idx] = 1;
                    map.put(friend1, idx++);
                }
                if (!map.containsKey(friend2)) {
                    parents[idx] = idx;
                    cnts[idx] = 1;
                    map.put(friend2, idx++);
                }

                sb.append(union(map.get(friend1), map.get(friend2))).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int union(int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if (pA == pB) {
            return cnts[pA];
        }

        if (pA > pB) {
            parents[pA] = pB;
            cnts[pB] += cnts[pA];
            return cnts[pB];
        }

        parents[pB] = pA;
        cnts[pA] += cnts[pB];
        return cnts[pA];
    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

}
