import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                return;
            }
            arr = new int[k];
            visited = new boolean[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            backTracking(0, 0, "");
            System.out.println();
        }
    }
    private static void backTracking(int idx, int cnt, String str) {
        if (cnt == 6) {
            System.out.println(str);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (str.equals("")) {
                    backTracking(i, cnt+1, str + arr[i]);
                } else {
                    backTracking(i, cnt+1, str+ " " + arr[i]);
                }
                visited[i] = false;
            }
        }
    }
}
