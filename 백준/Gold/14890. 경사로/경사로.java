import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    private static int N;
    private static int L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int[] arr2 = new int[N];
            int[] arr3 = new int[N];
            for (int j = 0; j < N; j++) {
                arr2[j] = arr[i][j];
                arr3[j] = arr[j][i];
            }
            if (canBuild(arr2)) {
                answer++;
            }
            if (canBuild(arr3)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean canBuild(int[] arr2) {
        int tmp = arr2[0];
        int cnt = 1;
        for (int i = 1; i < arr2.length; i++) {
            //높이가 동일
            if (tmp == arr2[i]) {
                cnt++;
                continue;
            }

            //높이가 1 올라갔다면 경사로 지을 수 있는지 판별한다.
            if (arr2[i] - tmp == 1) {
                //L보다 cnt가 작다면 경사로를 지을 칸이 부족하다.
                if (cnt < L) return false;
                //cnt가 L이상이라면 경사로 지을 수 있다.
                tmp = arr2[i];
                cnt = 1;
                continue;
            }

            //높이가 1 내려갔다면 경사로 지을 수 있는지 판별한다.
            if (tmp - arr2[i] == 1) {
                int cnt2 = 0;
                int idx = i;
                for (int j = i; j < arr2.length; j++) {
                    if (cnt2 == L) break;
                    idx = j;
                    if (tmp - arr2[j] == 1) cnt2++;
                    else return false;
                }

                //cnt2가 L보다 작다면 경사로를 지을 칸이 부족하다.
                if (cnt2 < L) return false;
                //cnt2가 L이라면 경사로 지을 수 있다.
                i = idx;
                tmp = arr2[i];
                cnt = 0;
                continue;
            }

            //나머지 경우 (높이가 1 초과로 오르락 내리락) -> 경사로를 지을 수 없음
            return false;

        }

        return true;
    }
}
