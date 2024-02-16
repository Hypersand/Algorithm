import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    private static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        comb(0, 0);

        Collections.sort(list);
        if (N > list.size()) {
            System.out.println(-1);
            return;
        }

        System.out.println(list.get(N - 1));
    }

    private static void comb(long num, int idx) {
        if (!list.contains(num)) {
            list.add(num);
        }

        for (int i = idx; i < 10; i++) {
            comb((num * 10) + nums[i], i + 1);
        }
    }

}
