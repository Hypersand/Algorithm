import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] parents;
    private static int[] cnts;
    private static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int F = Integer.parseInt(br.readLine());
            parents = new int[F * 2];
            cnts = new int[F * 2];
            map = new HashMap<>();
            int idx = 0;
            for (int j = 0; j < F; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String A = st.nextToken();
                String B = st.nextToken();
                if (!map.containsKey(A)) {
                    parents[idx] = idx;
                    cnts[idx] = 1;
                    map.put(A, idx++);
                }

                if (!map.containsKey(B)) {
                    parents[idx] = idx;
                    cnts[idx] = 1;
                    map.put(B, idx++);
                }

                sb.append(union(map.get(A), map.get(B))).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int union(int A, int B) {
        int pA = find(A);
        int pB = find(B);

        if (pA != pB) {
            cnts[pA] += cnts[pB];
            parents[pB] = pA;
        }
        return cnts[pA];
    }

    private static int find(int A) {
        if (parents[A] == A) {
            return A;
        }
        return parents[A] = find(parents[A]);
    }

}
