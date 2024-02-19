import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[1000002];
        int arrow = 0;
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (arr[height + 1] == 0) {
                arrow++;
            } else {
                arr[height + 1]--;
            }
            arr[height]++;
        }

        System.out.println(arrow);
    }
}
