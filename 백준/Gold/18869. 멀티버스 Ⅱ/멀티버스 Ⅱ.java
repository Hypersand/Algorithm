import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            binarySearch(list, i);
        }

        int cnt = 0;
        //i번째 우주와 j번째 우주를 비교
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                boolean flag = true;
                for (int k = 0; k < N; k++) {
                    if (arr[i][k] != arr[j][k]) {
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

    private static void binarySearch(List<Integer> list, int idx) {
        for (int i = 0; i < list.size(); i++) {
            int start = 0;
            int end = list.size() - 1;
            int target = list.get(i);
            while (start <= end) {
                int mid = (start + end) / 2;
                if (list.get(mid) <= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            arr[idx][i] = end;
        }
    }
}
