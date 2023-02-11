
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int K;
    private static boolean[] alphabet;
    private static String[] words;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            str = str.substring(4, str.length() - 4);
            words[i] = str;
        }

        if (K < 5) {
            System.out.println(0);
        }
        else if (K == 26) {
            System.out.println(N);
        }
        else {
            alphabet = new boolean[26];
            alphabet[0] = true;
            alphabet['c' - 'a'] = true;
            alphabet['n' - 'a'] = true;
            alphabet['t' - 'a'] = true;
            alphabet['i' - 'a'] = true;
            backTracking(0, 0);
            System.out.println(result);
        }

    }

    private static void backTracking(int count, int index) {
        if (count == K - 5) {
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                boolean canUse = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!alphabet[words[i].charAt(j) - 'a']) {
                        canUse = false;
                        break;
                    }
                }
                if (canUse) {
                    cnt++;
                }
            }
            result = Math.max(result, cnt);
            return;
        }

        for (int i = index; i < 26; i++) {
            if (!alphabet[i]) {
                alphabet[i] = true;
                backTracking(count+1,i+1);
                alphabet[i] = false;
            }
        }
    }
}
