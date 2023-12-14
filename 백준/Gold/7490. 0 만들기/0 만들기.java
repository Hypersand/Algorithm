import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

import static java.util.stream.Collectors.toList;

public class Main {
    private static int N;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            comb(1, "1");
            System.out.println(sb);
        }
    }

    private static void comb(int num, String s) {
        if (num == N) {
            String str = s.replaceAll(" ", "");
            Iterator<Integer> it= Arrays.stream(str.split("[+,-]"))
                    .map(Integer::parseInt)
                    .collect(toList()).iterator();
            int result = it.next();
            for(int i=0; i<str.length(); i++) {
                if(str.charAt(i) == '+') {
                    result += it.next();
                }else if(str.charAt(i) == '-') {
                    result -= it.next();
                }
            }
            if (result == 0) {
                sb.append(s).append("\n");
            }
            return;
        }


        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                comb(num + 1, s + " " + (num + 1));
            } else if (i == 1) {
                comb(num + 1, s + "+" + (num + 1));
            } else {
                comb(num + 1, s + "-" + (num + 1));

            }
        }


    }
}
