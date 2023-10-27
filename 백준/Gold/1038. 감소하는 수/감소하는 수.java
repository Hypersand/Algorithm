import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Long> list = new ArrayList<>();
    private static boolean[] visited = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10; i++) {
            list.add(Long.valueOf(i));
        }

        for (int i = 2; i <= 10; i++) {
            find(i, 0, 999);
        }

        if (N >= list.size()) {
            System.out.println(-1);
            return;
        }
        System.out.println(list.get(N));
    }

    private static void find(int maxDigit, int index, int selectNum) {
        if (index == maxDigit) {
            String tmp = "";
            for (int i = visited.length - 1; i >= 0; i--) {
                if (visited[i]) {
                    tmp += i;
                }
            }
            list.add(Long.parseLong(tmp));
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (i == 0 && index == 0) {
                continue;
            }

            if (i < selectNum) {
                visited[i] = true;
                find(maxDigit, index + 1, i);
                visited[i] = false;
            } else {
                break;
            }
        }
    }
}
