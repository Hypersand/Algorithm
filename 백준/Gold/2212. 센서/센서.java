
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] sensors = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensors);

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            list.add(sensors[i] - sensors[i - 1]);
        }

        Collections.sort(list);

        int ans = 0;

        for (int i = 0; i < N - K; i++) {
            ans += list.get(i);
        }

        System.out.println(ans);
    }
}
