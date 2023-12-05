import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int oneCnt = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] == 1) {
                oneCnt++;
            }
        }
        Arrays.sort(arr);
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] <= 1) break;
            if (queue.isEmpty()) {
                queue.add(arr[i]);
                continue;
            }
            sum += queue.poll() * arr[i];
        }
        if (!queue.isEmpty()) {
            sum += queue.poll();
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] > 0) break;
            if (queue.isEmpty()) {
                queue.add(arr[i]);
                continue;
            }
            sum += queue.poll() * arr[i];
        }

        if (!queue.isEmpty()) {
            sum += queue.poll();
        }

        if (oneCnt > 0) {
            sum += oneCnt;
        }

        System.out.println(sum);
    }
}
