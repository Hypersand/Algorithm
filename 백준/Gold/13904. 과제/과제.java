
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Assignment> list = new ArrayList<>();
        int maxDay = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Assignment(d, w));
            maxDay = Math.max(d, maxDay);
        }

        boolean[] used = new boolean[N];
        int answer = 0;

        for (int i = maxDay; i >= 1; i--) {
            int maxIdx = -1;
            int maxScore = -1;
            for (int j = 0; j < list.size(); j++) {
                if (!used[j] && list.get(j).d >= i && list.get(j).w > maxScore) {
                    maxScore = list.get(j).w;
                    maxIdx = j;
                }
            }
            if (maxIdx == -1) {
                continue;
            }
            used[maxIdx] = true;
            answer += maxScore;
        }

        System.out.println(answer);
    }

    public static class Assignment {
        int d;
        int w;

        public Assignment(int d, int w) {
            this.d = d;
            this.w = w;
        }
    }
}
