import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Point> stars = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            stars.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int answer = 0;
        for (int i = 0; i < K; i++) {
            int x = stars.get(i).x;
            for (int j = 0; j < K; j++) {
                int y = stars.get(j).y;
                //x와 y를 좌상단으로 하는 트램펄린을 만들었다 가정
                int cnt = 0;
                for (Point p : stars) {
                    if (p.x >= x && p.y >= y && p.x <= x + L && p.y <= y + L) {
                        cnt++;
                    }
                }
                answer = Math.max(answer, cnt);
            }
        }

        System.out.println(K - answer);
    }
}
