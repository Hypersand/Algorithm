
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[4000001];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i <= 4000000; i++) {
            if (isPrime[i]) {
                list.add(i);
                if (i <= Math.sqrt(4000000)) {
                    for (int j = i * i; j <= 4000000; j+=i) {
                        isPrime[j] = false;
                    }
                }
            }
        }

        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            int sum = list.get(i);
            if (sum == N) {
                count++;
                break;
            }
            for (int j = i + 1; j < list.size(); j++) {
                sum += list.get(j);
                if (sum == N) {
                    count++;
                    break;
                }
                if (sum > N) {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
