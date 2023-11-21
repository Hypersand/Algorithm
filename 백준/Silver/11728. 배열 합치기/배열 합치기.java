import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arrA = new int[N];
        int[] arrB = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int pA = 0;
        int pB = 0;
        StringBuilder sb = new StringBuilder();
        while (pA < N || pB < M) {
            if (pA >= N) {
                for (int i = pB; i < M; i++) {
                    sb.append(arrB[i] + " ");
                }
                break;
            }
            if (pB >= M) {
                for (int i = pA; i < N; i++) {
                    sb.append(arrA[i] + " ");
                }
                break;
            }
            if (arrA[pA] < arrB[pB]) {
                sb.append(arrA[pA] + " ");
                pA++;
            } else if (arrA[pA] == arrB[pB]) {
                sb.append(arrA[pA] + " " + arrB[pB] + " ");
                pA++;
                pB++;

            } else {
                sb.append(arrB[pB] + " ");
                pB++;
            }
        }

        System.out.println(sb);
    }
}
