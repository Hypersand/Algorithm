
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    private static char[] words;
    private static boolean[] used = new boolean[26];
    private static int L;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        words = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            words[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(words);

        backTracking(0, 0);

        System.out.println(sb);

    }

    private static void backTracking(int index, int cnt) {
        if (cnt == L) {
            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < 26; i++) {
                if (used[i]) {
                    if (i + 'a' == 'a' || i + 'a' == 'e' || i + 'a' == 'i' || i + 'a' == 'o' || i + 'a' == 'u') {
                        count1++;
                    }
                    else {
                        count2++;
                    }
                }
            }

            if (count1>=1&&count2>=2) {
                String ans = "";
                for (int i = 0; i < 26; i++) {
                    if (used[i]) {
                        ans += (char) (i + 'a');
                    }
                }
                sb.append(ans).append("\n");
            }

            return;
        }

        for (int i = index; i < words.length; i++) {
            if (!used[words[i]-'a']) {
                used[words[i]-'a'] = true;
                backTracking(i + 1, cnt + 1);
                used[words[i]-'a'] = false;
            }
        }
    }
}
