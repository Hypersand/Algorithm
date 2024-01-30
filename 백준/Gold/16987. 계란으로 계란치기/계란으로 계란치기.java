import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static List<Egg> list = new ArrayList<>();
    private static int[] remains;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        remains = new int[N];
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

        if (remains[idx] <= 0) {
            dfs(idx + 1, destroyCnt);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == idx) continue;
            if (remains[i] <= 0) continue;
            remains[idx] -= list.get(i).w;
            remains[i] -= list.get(idx).w;
            int cnt = 0;
            if (remains[idx] <= 0) cnt++;
            if (remains[i] <= 0) cnt++;
            dfs(idx + 1, destroyCnt + cnt);
            remains[idx] += list.get(i).w;
            remains[i] += list.get(idx).w;
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
