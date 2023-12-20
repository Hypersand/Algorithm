import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        comb("");
    }

    private static void comb(String str) {
        if (str.length() == N) {
            System.out.println(str);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (isGoodSequence(str + i)) {
                comb(str + i);
            }
        }
    }

    private static boolean isGoodSequence(String str) {
        if (str.length() >= 2) {
            if (str.charAt(str.length() - 2) == str.charAt(str.length() - 1)) {
                return false;
            }
        }

        for (int i = 1; i <= str.length() / 2; i++) {
            String front = str.substring(str.length() - 2 * i, str.length() - i);
            String back = str.substring(str.length() - i);
            if (front.equals(back)) return false;
        }
        return true;
    }
}
