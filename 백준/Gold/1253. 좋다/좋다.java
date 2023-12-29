import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int target = arr[i];
            int start = 0;
            int end = N - 1;
            while (start < end) {
                if (arr[start] + arr[end] < target) {
                    start++;
                } else if (arr[start] + arr[end] > target) {
                    end--;
                } else {
                    if (start == i) {
                        start++;
                        continue;
                    }
                    if (end == i) {
                        end--;
                        continue;
                    }
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
