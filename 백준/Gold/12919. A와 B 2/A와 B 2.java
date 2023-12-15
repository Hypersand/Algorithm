import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String S;
    private static String T;
    private static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        search(T);
        System.out.println(result);
    }

    private static void search(String T) {
        if (T.length() == S.length()) {
            if (T.equals(S)) {
                result = 1;
            }
            return;
        }

        if (T.charAt(T.length() - 1) == 'A') {
            search(T.substring(0, T.length() - 1));
        }
        String[] arr = T.split("");
        String tmp = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            tmp += arr[i];
        }
        if (tmp.charAt(tmp.length() - 1) == 'B') {
            search(tmp.substring(0, T.length() - 1));
        }
    }
}