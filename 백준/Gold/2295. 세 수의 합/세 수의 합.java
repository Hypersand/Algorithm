
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                list.add(arr[i] + arr[j]);
            }
        }

        Collections.sort(list);

        int max = 0;

        for (int i = N-1; i >= 0; i--) {
            for (int j = i-1; j >= 0; j--) {
                int tmp = arr[i] - arr[j];
                if (find(tmp) && arr[i] > max) {
                    max = arr[i];
                }
            }
        }

        System.out.println(max);
    }

    public static boolean find(int value) {
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (list.get(mid) == value) {
                return true;
            }
            else if (list.get(mid) > value) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return false;
    }
}
