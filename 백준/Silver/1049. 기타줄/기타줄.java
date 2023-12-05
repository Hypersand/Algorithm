import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] bundles = new int[M];
        int[] pieces = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int bundle = Integer.parseInt(st.nextToken());
            int piece = Integer.parseInt(st.nextToken());
            bundles[i] = bundle;
            pieces[i] = piece;
        }
        Arrays.sort(bundles);
        Arrays.sort(pieces);
        if (pieces[0] * 6 < bundles[0]) {
            System.out.println(pieces[0] * N);
            return;
        }
        int bundleCnt = (int)Math.floor(N / (double) 6);
        int sum = bundles[0] * bundleCnt;
        N -= bundleCnt * 6;
        if (pieces[0] * N < bundles[0]) {
            sum += pieces[0] * N;
        } else {
            sum += bundles[0];
        }

        System.out.println(sum);
    }
}
