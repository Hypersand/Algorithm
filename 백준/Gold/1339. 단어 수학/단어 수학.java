
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strs = new String[N];
        Integer [] used = new Integer[26];
        Arrays.fill(used,0);

        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            char[] str = strs[i].toCharArray();
            int pos = 1;
            for(int j = str.length -1; j>=0; j--) {
                used[str[j] - 'A'] += Integer.valueOf(pos);
                pos*=10;
            }
        }

        Arrays.sort(used, Collections.reverseOrder());

        int sum = 0;
        int count = 9;
        for (int i = 0; i< used.length; i++) {
            if (used[i]== 0) {
                break;
            }
            sum += count*used[i];
            count--;
        }
        System.out.println(sum);
    }

}

