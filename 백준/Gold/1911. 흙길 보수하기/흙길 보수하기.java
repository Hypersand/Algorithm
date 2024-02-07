import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] holes = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            holes[i][0] = Integer.parseInt(st.nextToken()); //시작 위치
            holes[i][1] = Integer.parseInt(st.nextToken()); //끝 위치
        }

        Arrays.sort(holes, (int[] hole1, int[] hole2) -> hole1[0] - hole2[0]);

        int lastPos = holes[0][0];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int end = holes[i][1];
            if (lastPos >= end) continue;
            if (lastPos < holes[i][0]) {
                lastPos = holes[i][0];
            }
            //lastPos를 필요한 널빤지 갯수만큼 늘려야 함.
            int cnt = (int)Math.ceil((double)(end - lastPos) / L);
            answer += cnt;
            lastPos += cnt * L;
        }

        System.out.println(answer);
    }
}
