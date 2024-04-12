import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static List<Point> list = new ArrayList<>();
    private static List<Point> shelterList = new ArrayList<>();
    private static boolean[] isShelter;
    private static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isShelter = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y));
        }

        comb(0, 0);

        System.out.println(answer);
    }

    //대피소 선정
    private static void comb(int idx, int cnt) {
        if (cnt == K) {
            validate();
            return;
        }


        for (int i = idx; i < N; i++) {
            shelterList.add(list.get(i));
            isShelter[i] = true;
            comb(i + 1, cnt + 1);
            shelterList.remove(shelterList.size() - 1);
            isShelter[i] = false;
        }
    }

    private static void validate() {
        //집에서 가장 가까운 대피소로 이동할 때 가장 긴 거리가 최소가 되도록 대피소를 설치해야 함.
        //K개의 집을 선택하고, 그때 대피소와 가장 멀리 떨어진 집과의 거리를 구하려고 한다.

        int maxDist = 0;

        for (int i = 0; i < N; i++) {
            //각 집마다 가장 가까운 대피소와의 거리를 구한다.
            int dist = Integer.MAX_VALUE;
            if (!isShelter[i]) {
                for (int j = 0; j < K; j++) {
                    Point shelterP = shelterList.get(j);
                    int tmpDist = Math.abs(shelterP.x - list.get(i).x) + Math.abs(shelterP.y - list.get(i).y);
                    dist = Math.min(tmpDist, dist);

                }
            } else {
                continue;
            }

            //구한 dist 중 최대 거리 구하기.
            maxDist = Math.max(maxDist, dist);
        }

        //최대 거리가 최소가 되도록 하는 정답
        answer = Math.min(maxDist, answer);
    }
}
