

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] counting = new int[10];

        while (N != 0) {
            counting[N%10]++;
            N /= 10;
        }

        for (int i = 9; i >= 0; i--) {
            if (counting[i] != 0) {
                for (int j = 0; j < counting[i]; j++) {
                    sb.append(i);
                }
            }
        }
        System.out.println(sb);
    }
}