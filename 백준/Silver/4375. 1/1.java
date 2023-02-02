
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            long b = 1;
            int k = 1;
            while (b % n != 0) {
                b = b * 10 + 1;
                k++;
                b %= n;
            }
            System.out.println(k);
        }

    }
}
