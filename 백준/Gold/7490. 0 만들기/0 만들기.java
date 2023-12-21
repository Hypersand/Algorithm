import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            comb(N, 1, "1");
            System.out.println(sb);
        }
    }

    private static void comb(int N, int idx, String str) {
        if (idx == N) {
            if (isZero(N, str)) {
                sb.append(str).append("\n");
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                comb(N, idx + 1, str + "+" + (idx + 1));
                continue;
            }
            if (i == 2) {
                comb(N, idx + 1, str + "-" + (idx + 1));
                continue;
            }
            comb(N, idx + 1, str + " " + (idx + 1));
        }

    }

    private static boolean isZero(int N, String str) {
        str = str.replaceAll(" ", "");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                list.add(String.valueOf(str.charAt(i)));
            }
        }

        String[] arr = str.split("[+\\-]");
        if (arr.length == 1) {
            return false;
        }

        int answer = Integer.parseInt(arr[0]);
        int idx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (list.get(idx).equals("+")) {
                answer += Integer.parseInt(arr[i]);
            } else {
                answer -= Integer.parseInt(arr[i]);
            }
            idx++;
        }

        if (answer == 0) {
            return true;
        }
        return false;
    }
}
