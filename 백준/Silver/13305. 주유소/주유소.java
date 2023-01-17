
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        drive[] arr = new drive[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            arr[i] = new drive(0, Integer.parseInt(st.nextToken()));
        }

        arr[N - 1] = new drive(0, 0);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i].price = Integer.parseInt(st.nextToken());
        }

        int min = arr[0].price;
        int total = 0;
        for (int i = 0; i < N-1; i++) {
            min = Math.min(arr[i].price, min);
            total += arr[i].distance * min;
        }

        System.out.println(total);


    }

    private static class drive {
        int price;
        int distance;

        public drive(int price, int distance) {
            this.price = price;
            this.distance = distance;
        }

    }
}
