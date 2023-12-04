import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        int[] ans = new int[N];
        for (int i = 0; i < N - 1; i++) {
            double slope = arr[i + 1] - arr[i];
            ans[i]++;
            ans[i+1]++;
            for (int j = i + 2; j < N; j++) {
                double tmpSlope = (arr[j] - arr[i]) / (double) (j - i);
                if (slope < tmpSlope) {
                    slope = tmpSlope;
                    ans[i]++;
                    ans[j]++;
                }
            }
        }

        Arrays.sort(ans);
        System.out.println(ans[N-1]);
    }
}
