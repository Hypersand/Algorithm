import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //걸리는 시간
            arr[i][1] = Integer.parseInt(st.nextToken()); //끝내야 할 시간
        }

        Arrays.sort(arr, (int[] arr1, int[] arr2) -> {
            if (arr1[1] == arr2[1]) {
                return arr1[0] - arr2[0];
            } else {
                return arr2[1] - arr1[1];
            }
        });

        int lastTime = arr[0][1];
        for (int i = 0; i < N; i++) {
            if (lastTime > arr[i][1]) {
                lastTime = arr[i][1];
            }
            lastTime -= arr[i][0];
        }

        if (lastTime < 0) {
            System.out.println(-1);
        } else {
            System.out.println(lastTime);
        }
    }
}
