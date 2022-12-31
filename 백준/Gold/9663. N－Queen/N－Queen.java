
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static int [] arr;
    private static int count = 0;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        backTracking(0);
        System.out.println(count);
    }

    private static void backTracking(int index) {
        if(index == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[index] = i;
            if(possible(index)) {
                backTracking(index+1);
            }
        }
    }

    private static boolean possible(int index) {

        for (int i = 0; i < index; i++) {
            if(arr[i]==arr[index]) {
                return false;
            }
            else if(Math.abs(i-index)==Math.abs(arr[i]-arr[index])) {
                return false;
            }
        }
        return true;
    }
}
