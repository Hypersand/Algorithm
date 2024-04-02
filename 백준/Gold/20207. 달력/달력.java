import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
                arr[j]++;
            }
        }

        int sum = 0;
        int width = 0;
        int height = 0;
        for (int i = 1; i <= 1000; i++) {
            if (arr[i] != 0) {
                width++;
                height = Math.max(height, arr[i]);
                continue;
            }

            sum += (width * height);
            width = 0;
            height = 0;
        }


        System.out.println(sum);
    }

}
