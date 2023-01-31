
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        long[] sub_A = new long[(n + 1) * n/2];

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        long[] sub_B = new long[(m + 1) * m/2];

        int k = 0;
        for (int i = 0; i < n; i++) {
            long a = A[i];
            sub_A[k++] = a;
            for (int j = i + 1; j < n; j++) {
                a += A[j];
                sub_A[k++] = a;
            }
        }

        int t = 0;
        for (int i = 0; i < m; i++) {
            long b = B[i];
            sub_B[t++] = b;
            for (int j = i + 1; j < m; j++) {
                b += B[j];
                sub_B[t++] = b;
            }
        }

        Arrays.sort(sub_A);
        Arrays.sort(sub_B);

        int left = 0;
        int right = sub_B.length - 1;
        long count = 0;
        while (left < sub_A.length && right >= 0) {
            long left_val = sub_A[left];
            long right_val = sub_B[right];
            if (left_val + right_val == T) {
                long left_count = 0;
                long right_count = 0;
                while (left < sub_A.length && sub_A[left] == left_val) {
                    left++;
                    left_count++;
                }
                while (right >= 0 && sub_B[right] == right_val) {
                    right--;
                    right_count++;
                }
                count += left_count * right_count;
            }
            else if (left_val + right_val > T) {
                right--;
            }
            else {
                left++;
            }
        }

        System.out.println(count);
    }
}
