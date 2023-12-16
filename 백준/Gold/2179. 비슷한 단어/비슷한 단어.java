import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int maxLength = 0;
        String s_answer = "";
        String t_answer = "";
        for (int i = 0; i < N - 1; i++) {
            String s = arr[i];
            String t;
            for (int j = i + 1; j < N; j++) {
                t = arr[j];
                int length = Math.min(s.length(), t.length());
                int cnt = 0;
                for (int k = 0; k < length; k++) {
                    if (s.charAt(k) != t.charAt(k)) {
                        break;
                    }
                    cnt++;
                }

                if (maxLength < cnt) {
                    maxLength = cnt;
                    s_answer = s;
                    t_answer = t;
                }
            }
        }

        System.out.println(s_answer);
        System.out.println(t_answer);
    }
}
