import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static List<Egg> list = new ArrayList<>();
    private static int[] remains;
    private static boolean[] destroyed;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        remains = new int[N];
        destroyed = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            remains[i] = list.get(i).s;
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int idx, int destroyCnt) {
        if (idx == N) {
            answer = Math.max(answer, destroyCnt);
            return;
        }

        if (destroyed[idx]) {
            dfs(idx + 1, destroyCnt);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == idx) continue;
            if (destroyed[i]) continue;
            Egg egg1 = list.get(idx);
            Egg egg2 = list.get(i);
            remains[idx] -= egg2.w;
            remains[i] -= egg1.w;
            if (remains[idx] <= 0 && remains[i] <= 0) {
                destroyed[idx] = true;
                destroyed[i] = true;
                dfs(idx + 1, destroyCnt + 2);
                destroyed[idx] = false;
                destroyed[i] = false;
            } else if (remains[idx] <= 0) {
                destroyed[idx] = true;
                dfs(idx + 1, destroyCnt + 1);
                destroyed[idx] = false;
            } else if (remains[i] <= 0) {
                destroyed[i] = true;
                dfs(idx + 1, destroyCnt + 1);
                destroyed[i] = false;
            } else {
                dfs(idx + 1, destroyCnt);
            }
            remains[idx] += egg2.w;
            remains[i] += egg1.w;
        }

        answer = Math.max(answer, destroyCnt);
    }

    private static class Egg {
        private int s;  //내구도
        private int w;  //무게

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }

}
