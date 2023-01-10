import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        System.out.println(DAC(A,B,C));
    }

    private static long DAC(long  a, long  b, long  c) {
       if(b == 0) return 1;
       else if (b == 1) {
           return a % c;
       }
       else {
           long  tmp = DAC(a, b / 2, c)%c;
           if (b % 2 == 0) {
               return (tmp*tmp)%c;
           }
           else {
               return (tmp*((tmp*(a%c))%c))%c;
           }
       }
    }
}
