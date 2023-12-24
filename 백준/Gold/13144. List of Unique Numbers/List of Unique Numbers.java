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
        int start = 0;
        int end = 0;
        int max = 0;
        long total = 0;
        Set<Integer> set = new HashSet<>();
        while (start < N) {
            if (end == N) {
                total += end - start;
                start++;
                continue;
            }

            if (!set.contains(arr[end])) {
                set.add(arr[end++]);
                max = Math.max(max, end - start);
                continue;
            }

            //end 위치의 숫자가 이미 존재하는 숫자라면?
            while (set.size() != 0 && set.contains(arr[end])) {
                total += end - start;
                set.remove(arr[start++]);
            }
        }


        System.out.println(total);
    }
}
