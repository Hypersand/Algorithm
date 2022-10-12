

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();
        Integer[] arr = new Integer[N.length()];
        for (int i = 0; i < N.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(N.charAt(i)));
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb);

    }
}
