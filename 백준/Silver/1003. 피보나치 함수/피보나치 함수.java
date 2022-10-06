

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int count = 0;
    public static int count1 = 0;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int [] arr = new int[41];
        int [] arr1 = new int[41];
        arr[0] = 1;
        arr1[0] = 0;
        arr[1] = 0;
        arr1[1] = 1;

        for(int i = 2; i<41; i++) {
            arr[i] = arr[i-1] + arr[i-2];
            arr1[i] = arr1[i-1] + arr1[i-2];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(arr[N] + " " + arr1[N]).append("\n");
        }
        System.out.println(sb);
    }

}
