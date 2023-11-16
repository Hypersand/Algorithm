import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] arr = br.readLine().split("");
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                System.out.println("1 1");
                continue;
            }
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < arr.length; j++) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < arr.length; j++) {
                if (map.get(arr[j]) < K) continue;

                int cnt = 1;
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[j].equals(arr[k])) {
                        cnt++;
                    }
                    if (cnt == K) {
                        int length = k - j + 1;
                        min = Math.min(min, length);
                        max = Math.max(max, length);
                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}
