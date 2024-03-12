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
        int X = Integer.parseInt(st.nextToken()) / 1000;
        int[][] tastes = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            tastes[i][0] = A;
            tastes[i][1] = B;
        }

        Arrays.sort(tastes, (e1, e2) -> {
            return (e2[0] - e2[1]) - (e1[0] - e1[1]);
        });

        int answer = 0;
        for (int i = 0; i < N; i++) {
            //5000원짜리를 골랐을때 뒤에 남은 메뉴들을 고를 수 있는지 검증해야 함.
            if (X - 5 >= N - i - 1 && tastes[i][0] > tastes[i][1]) {
                answer += tastes[i][0];
                X -= 5;

            } else {
                answer += tastes[i][1];
                X -= 1;
            }
        }

        System.out.println(answer);
    }
}
