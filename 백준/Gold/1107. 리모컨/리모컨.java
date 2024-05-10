import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int maxCount;
    private static List<Integer> activatedBtn = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] notActivatedBtn = new boolean[10];
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                notActivatedBtn[Integer.parseInt(st.nextToken())] = true;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (!notActivatedBtn[i]) activatedBtn.add(i);
        }

        if (N == 100) {
            System.out.println(0);
            return;
        }

        if (N > 100) {
            maxCount = N - 100;
        } else {
            maxCount = 100 - N;
        }

        if (M == 0) {
            System.out.println(Math.min(maxCount, String.valueOf(N).length()));
            return;
        }

        backTracking(0, 0);
        System.out.println(maxCount);
    }

    private static void backTracking(int num, int degree) {
        if (degree == 6) return;

        for (int i = 0; i < activatedBtn.size(); i++) {
            int newNum = num + activatedBtn.get(i) * (int)Math.pow(10, degree);
            // 100 -> newNum -> +버튼 or -버튼으로 목적지 이동
            int newCnt = degree + 1;
            if (newNum >= N) {
                newCnt += newNum - N;
            } else {
                newCnt += N - newNum;
            }

            maxCount = Math.min(newCnt, maxCount);
            backTracking(newNum, degree + 1);
        }
    }
}
