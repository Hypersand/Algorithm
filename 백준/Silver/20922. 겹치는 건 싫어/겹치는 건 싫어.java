import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] nums = new int[100001];

        int answer = 1;
        int start = 0;
        int end = 1;
        nums[arr[start]]++;
        while (end < N) {
            nums[arr[end]]++;

            while (nums[arr[end]] > K && start < end) {
                nums[arr[start]]--;
                start++;
            }

            answer = Math.max(answer, end - start + 1);
            end++;
        }

        System.out.println(answer);
    }
}
