
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        long[] sumAB = new long[n*n];
        long[] sumCD = new long[n*n];

        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumAB[k++] = A[i] + B[j];
            }
        }

        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumCD[t++] = C[i] + D[j];
            }
        }

        Arrays.sort(sumAB);
        Arrays.sort(sumCD);

        int start = 0;
        int end = sumCD.length - 1;
        long count = 0;
        while (start < sumAB.length && end >= 0) {
            long sumAB_value = sumAB[start];
            long sumCD_value = sumCD[end];

            if (sumAB[start] + sumCD[end] == 0) {
                long sumAB_count = 0;
                long sumCD_count = 0;
                while (start < sumAB.length && sumAB[start] == sumAB_value) {
                    sumAB_count++;
                    start++;
                }
                while (end >= 0 && sumCD[end] == sumCD_value) {
                    end--;
                    sumCD_count++;
                }

                count += sumAB_count * sumCD_count;
            }
            else if (sumAB[start] + sumCD[end] > 0) {
                end--;
            }
            else {
                start++;
            }
        }

        System.out.println(count);
    }
}
