import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
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
        Set<Integer> set = new HashSet<>();
        int start = 0;
        int end = 0;
        long cnt = 0;
        while (start < N) {
            if (end == N) {
                cnt += end - start;
                start++;
                continue;
            }

            if (!set.contains(arr[end])) {
                set.add(arr[end]);
                end++;
                continue;
            }
            //end의 숫자가 이미 존재하는 숫자라면?
            cnt += end - start;
            set.remove(arr[start]);
            start++;
        }
        System.out.println(cnt);
    }
}
