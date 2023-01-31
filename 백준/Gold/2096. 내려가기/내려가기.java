
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a1,a2,a3;
        int b1 = 0;
        int b2 = 0;
        int b3 = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int t1,t2,t3;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a1 = Integer.parseInt(st.nextToken());
            a2 = Integer.parseInt(st.nextToken());
            a3 = Integer.parseInt(st.nextToken());

            t1 = Math.max(b1, b2) + a1;
            t2 = Math.max(b1, Math.max(b2, b3)) + a2;
            t3 = Math.max(b2, b3) + a3;
            b1 = t1;
            b2 = t2;
            b3 = t3;

            t1 = Math.min(c1, c2) + a1;
            t2 = Math.min(c1, Math.min(c2, c3)) + a2;
            t3 = Math.min(c2, c3) + a3;
            c1 = t1;
            c2 = t2;
            c3 = t3;
        }

        System.out.println(Math.max(b1, Math.max(b2, b3)) + " " + Math.min(c1, Math.min(c2, c3)));
    }

}