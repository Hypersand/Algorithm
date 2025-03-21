
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] sArr;
    private static int[] wArr;
    private static boolean[] isDestroyed;
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sArr = new int[N];
        wArr = new int[N];
        isDestroyed = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            sArr[i] = s;
            wArr[i] = w;
        }

        if (N == 1) {
            System.out.println(0);
            return;
        }

        backTracking(0, 0);

        System.out.println(answer);
    }

    private static void backTracking(int idx, int cnt) {
        if (idx == N) {
            answer = Math.max(answer, cnt);
            return;
        }

        if (isDestroyed[idx]) {
            backTracking(idx + 1, cnt);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (idx == i) continue;
            if (isDestroyed[i]) continue;
            int tmp1 = sArr[idx];
            int tmp2 = sArr[i];
            if (sArr[idx] - wArr[i] <= 0) {
                if (sArr[i] - wArr[idx] <= 0) {
                    isDestroyed[idx] = true;
                    isDestroyed[i] = true;
                    backTracking(idx + 1, cnt + 2);
                    isDestroyed[idx] = false;
                    isDestroyed[i] = false;
                } else {
                    isDestroyed[idx] = true;
                    sArr[i] -= wArr[idx];
                    backTracking(idx + 1, cnt + 1);
                    sArr[i] = tmp2;
                    isDestroyed[idx] = false;
                }
            } else {
                if (sArr[i] - wArr[idx] <= 0) {
                    sArr[idx] -= wArr[i];
                    isDestroyed[i] = true;
                    backTracking(idx + 1, cnt + 1);
                    sArr[idx] = tmp1;
                    isDestroyed[i] = false;

                } else {
                    sArr[idx] -= wArr[i];
                    sArr[i] -= wArr[idx];
                    backTracking(idx + 1, cnt);
                    sArr[idx] = tmp1;
                    sArr[i] = tmp2;
                }
            }
        }

        answer = Math.max(answer, cnt);

    }
}
