import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, L;
    private static List<Point> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        if (K == 1) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            Point p1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Point p2 = list.get(j);
                answer = Math.max(answer, validate(p1.x, p1.y));
                answer = Math.max(answer, validate(p2.x, p2.y));
                answer = Math.max(answer, validate(p1.x, p2.y));
                answer = Math.max(answer, validate(p2.x, p1.y));
            }
        }

        System.out.println(list.size() - answer);
    }

    private static int validate(int x, int y) {
        int cnt = 0;
        for (Point p : list) {
            if (p.x >= x && p.y >= y && p.x <= x + L && p.y <= y + L) {
                cnt++;
            }
        }
        return cnt;
    }
}
