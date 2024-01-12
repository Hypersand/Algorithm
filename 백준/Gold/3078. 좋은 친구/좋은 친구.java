import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] nums = new int[21];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().length();
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= K; i++) {
            if (i == N) break;
            queue.add(arr[i]);
            nums[arr[i]]++;
        }

        long answer = 0;
        int idx = K + 1;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            nums[num]--;
            answer += nums[num];
            if (idx < N) {
                nums[arr[idx]]++;
                queue.add(arr[idx++]);
            }
        }
        System.out.println(answer);
    }
}
