import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        int zeroCnt = 0;
        int oneCnt = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].equals("0")) {
                if (arr[i + 1].equals("1")) {
                    zeroCnt++;
                }

            } else {
                if (arr[i + 1].equals("0")) {
                    oneCnt++;
                }
            }
        }

        if (zeroCnt == 0 && oneCnt == 0) {
            System.out.println(0);
            return;
        }

        if (arr[arr.length - 1].equals("0")) {
            zeroCnt++;
        } else {
            oneCnt++;
        }

        System.out.println(Math.min(zeroCnt,oneCnt));
    }
}
