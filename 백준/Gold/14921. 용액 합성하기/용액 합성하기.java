import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = N - 1;
        int min = Integer.MAX_VALUE;
        while (start < end) {
            int result = arr[start] + arr[end];
            //합이 음수라면 -> 합이 양수에 가깝도록 만들어야 됨
            if (result < 0) {
                start++;
            }
            //합이 양수라면 -> 합이 음수에 가깝도록 만들어야 함.
            else {
                end--;
            }

            if (Math.abs(result) < Math.abs(min)) {
                min = result;
            }
        }

        System.out.println(min);
    }
}
