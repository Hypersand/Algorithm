import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static long P, Q;
    private static Map<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        if (N == 0) {
            System.out.println(1);
            return;
        }
        System.out.println(dfs(N));
    }

    private static long dfs(long num) {
        if (num == 0) {
            return 1;
        }
        if (map.containsKey(num)) {
            return map.get(num);
        }

        map.put(num, dfs(num / P) + dfs(num / Q));
        return map.get(num);
    }

}
