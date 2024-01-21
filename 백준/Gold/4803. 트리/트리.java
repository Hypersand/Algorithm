import java.io.*;
import java.util.*;

public class Main {
    private static int[] parents;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }

            parents = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parents[i] = i;
            }

            Set<Integer> set = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                int pA = find(a);
                int pB = find(b);

                if (pA != pB) {
                    union(a, b);
                } else {
                    list.add(pA);
                }
            }

            for (int i = 1; i <= n; i++) {
                find(i);
            }

            for (int node : list) {
                set.add(parents[node]);
            }

            int treeCnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!set.contains(parents[i])) {
                    treeCnt++;
                    set.add(parents[i]);
                }
            }

            if (treeCnt == 0) {
                sb.append("Case ").append(t++).append(": No trees.").append("\n");
            } else if (treeCnt == 1) {
                sb.append("Case ").append(t++).append(": There is one tree.").append("\n");
            } else {
                sb.append("Case ").append(t++).append(": A forest of ").append(treeCnt).append(" trees.").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if (pA > pB) {
            parents[pA] = pB;
        } else {
            parents[pB] = pA;
        }
    }

    private static int find(int a) {
        if (parents[a] == a){
            return a;
        }

        return parents[a] = find(parents[a]);
    }
}
