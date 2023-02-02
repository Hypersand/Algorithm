
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(1000001); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= isPrime.length-1; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int n = 0;
        while ((n =sc.nextInt()) != 0) {
            int count = 0;
            for (int i = 2; i<=n/2; i++) {
                if (isPrime[i]&&isPrime[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println("Goldbach's conjecture is wrong.");
            }

        }


    }
}
