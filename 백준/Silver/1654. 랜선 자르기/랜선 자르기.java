
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];

        int maxLength = 0;
        for (int i = 0; i < K; i++) {
            long num = Long.parseLong(br.readLine());
            arr[i] = num;
            maxLength = (int) Math.max(maxLength, num);
        }
        
        
        System.out.println(binarySearch(1, maxLength, arr));
        
        
    }
    
    private static long binarySearch(long start, long end, long[] arr) {
        
        long mid = 0;
        long length = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            long cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt < N) {
                end = mid - 1;
            } else {
                length = Math.max(length, mid);
                start = mid + 1;
            }
        }

        return length;
    }
}
