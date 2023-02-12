
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N + 1];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        System.out.println(binarySearch(0, max));
    }

    private static int binarySearch(int start, int end) {
        int mid = (start + end) / 2;
        if (start <= end) {
            long sum = 0;
            for (int i = 1; i <= N; i++) {
                if (trees[i] > mid) {
                    sum += trees[i] - mid;
                    if (sum > M) {
                        return binarySearch(mid+1, end);
                    }
                }
            }

            if (sum == M) {
                return mid;
            }

            if (sum < M) {
                return binarySearch(start, mid-1);
            }

        }
        return mid;
    }
}
