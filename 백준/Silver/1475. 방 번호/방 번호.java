import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            if (num == 6 || num == 9) {
                map.put(6, map.getOrDefault(6, 0) + 1);
                answer = Math.max(answer, map.get(6) / 2 + map.get(6) % 2);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
                answer = Math.max(answer, map.get(num));
            }
        }

        System.out.println(answer);
    }
}
