
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int L;
    private static int C;
    private static boolean [] used;
    private static String[] str;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        used = new boolean[C];

        str = new String[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            str[i] = st.nextToken();
        }
        Arrays.sort(str);

        comb(0,0);
        System.out.println(sb);
    }

    private static void comb(int length, int index) {
        if (length == L) {
            int count1 = 0;
            int count2 = 0;
            String word = "";
            for (int i = 0; i < C; i++) {
                if (used[i]) {
                    word += str[i];
                    if (str[i].equals("a") || str[i].equals("e") || str[i].equals("i") || str[i].equals("o") || str[i].equals("u")) {
                        count1++;
                    }
                    else {
                        count2++;
                    }
                }
            }

            if (count1 >= 1 && count2 >= 2) {
                sb.append(word + "\n");
            }
            return;
        }

        for (int i = index; i < C; i++) {
            used[i] = true;
            comb(length + 1,i+1);
            used[i] = false;
        }
    }
}
