import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] words = br.readLine().split("");
            sb.append(palindrome(words, 0, words.length - 1, 0)).append("\n");
        }
        System.out.println(sb);
    }

    private static int palindrome(String[] words, int start, int end, int removeCnt) {
        if (removeCnt >= 2) {
            return 2;
        }

        while (start < end) {
            if (words[start].equals(words[end])) {
                start++;
                end--;
                continue;
            }
            return Math.min(palindrome(words, start, end - 1, removeCnt + 1),
                    palindrome(words, start + 1, end, removeCnt + 1));
        }
        return removeCnt;
    }
}
