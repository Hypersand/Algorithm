
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] str = br.readLine().split("");
        int[] arr = new int[10];
        int sum = 0;

        for (int i = 0; i < str.length; i++) {
            arr[Integer.parseInt(str[i])]++;
            sum += Integer.parseInt(str[i]);
        }
        if (arr[0] == 0 || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        for (int i = 9; i >=0; i--) {
            int count = arr[i];
            while (count > 0) {
                sb.append(i);
                count--;
            }
        }

        System.out.println(sb);

    }
}
