import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        backTracking(0, "");
    }

    private static void backTracking(int idx, String num) {
        if (idx == N) {
            System.out.println(num);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (validate(num, i)) {
                backTracking(idx + 1, num + i);
            }
        }

    }

    private static boolean validate(String num, int i) {
        String newNum = num + i;
        for (int j = 1; j <= newNum.length() / 2; j++) {
            String front = newNum.substring(newNum.length() - (2 * j), newNum.length() - j);
            String end = newNum.substring(newNum.length() - j);
            if (front.equals(end)) {
                return false;
            }
        }
        return true;
    }
}
