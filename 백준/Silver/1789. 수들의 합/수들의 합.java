import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        int cnt = 0;
        int num = 1;
        while (true) {
            if (S - num >= 0) {
                cnt++;
                S -= num;
                num++;
            } else {
                break;
            }
        }

        System.out.println(cnt);

    }
}
