import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int target = Y - X;
        int start = 0;
        int end = 100000;

        while (start <= end) {
            int mid = (start + end) / 2;

            //mid일 일때의 최댓값을 구해야 함.
            long sum = 0;
            for (int i = 1; i <= mid / 2; i++) {
                sum += i;
            }
            sum *= 2;
            if (mid % 2 != 0) {
                sum += (mid / 2) + 1;
            }

            if (sum >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}
