import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        // T -> S 로 변환가능한지 판별하기
        while (T.length() > S.length()) {
            if (T.charAt(T.length() - 1) == 'A') {
                T = T.substring(0, T.length() - 1);
                continue;
            }
            T = T.substring(0, T.length() - 1);
            String tmp = "";
            for (int i = T.length() - 1; i >= 0; i--) {
                tmp += String.valueOf(T.charAt(i));
            }
            T = tmp;
        }

        if (S.equals(T)) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}
