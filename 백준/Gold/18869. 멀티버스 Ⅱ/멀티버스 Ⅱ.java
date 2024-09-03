import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        int[][] answer = new int[M][N];
        for (int i = 0; i < M; i++) {
            int[] tmp = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                tmp[j] = arr[i][j];
            }

            Arrays.sort(tmp);
            int[] order = findOrder(tmp, i);
            for (int j = 0; j < N; j++) {
                answer[i][j] = order[j];
            }
        }

        int cnt = 0;
        // 우주 비교
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                boolean flag = true;
                for (int k = 0; k < N; k++) {
                    if (answer[i][k] != answer[j][k]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    private static int[] findOrder(int[] tmp, int order) {
        int[] tmp2 = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            int start = 0;
            int end = tmp.length - 1;
            int key = arr[order][i];
            while (start <= end) {
                int mid = (start + end) / 2;
                if (tmp[mid] >= key) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            tmp2[i] = start;
        }

        return tmp2;
    }
}
