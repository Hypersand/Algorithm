import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static int[][] arr;
    private static boolean[] visited;
    private static int cnt = 0;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[3][N + 1];
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[1][i] = i;
            arr[2][i] = num;
        }

        for (int i = 1; i <= N; i++) {
            if (arr[1][i] == arr[2][i]) {
                cnt++;
                sb.append(arr[1][i]).append("\n");
            } else {
                visited = new boolean[N + 1];
                dfs(i, i);
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }

    private static void dfs(int idx, int target) {
        if (arr[2][idx] == target) {
            cnt++;
            sb.append(target).append("\n");
            return;
        }

        if (!visited[idx]) {
            visited[idx] = true;
            dfs(arr[2][idx], target);
        }
    }
}
