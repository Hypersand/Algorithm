import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] sum = new int[N + 1];
        Map<Integer, Long> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        long answer = 0;
        for (int i = 1; i <= N; i++) {
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
            if (sum[i] == K) answer++;
            if (map.containsKey(sum[i] - K)) {
                answer += map.get(sum[i] - K);
            }

            map.put(sum[i], map.getOrDefault(sum[i], 0L) + 1);
        }

        System.out.println(answer);

    }
}
