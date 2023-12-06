import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][N];
        List<Integer>[] lists = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            Set<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                set.add(arr[i][j]);
            }
            lists[i] = new ArrayList<>(set);
            Collections.sort(lists[i]);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = Collections.binarySearch(lists[i], arr[i][j]);
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                if (Arrays.equals(arr[i], arr[j])) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
