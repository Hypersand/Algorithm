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
        int twoCount = 0;
        int oneCount = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            twoCount += arr[i] / 2;
            oneCount += arr[i] % 2;
            sum += arr[i];
        }

        if (oneCount > twoCount || sum / 3 > twoCount || sum % 3 != 0) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }
}
