import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("a")) {
                cnt++;
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int bCnt = 0;
            for (int j = i; j < i + cnt; j++) {
                if (arr[j % arr.length].equals("b")) {
                    bCnt++;
                }
            }
            answer = Math.min(bCnt, answer);
        }

        System.out.println(answer);
    }
}
