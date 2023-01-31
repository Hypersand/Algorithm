
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    private static int [] trees;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }

        System.out.println(binarySearch(M, 0, max));
    }
    private static int binarySearch(long key, int start, int end) {
        int mid = (start + end) / 2;
        long woodCut = 0;

        if(start <= end) {
            for (int i = 0; i < trees.length; i++) {
                if (mid < trees[i]) {
                    woodCut += trees[i] - mid;
                }
            }
            if (key == woodCut) {
                return mid;
            }
            else if (key < woodCut) {
                return binarySearch(key ,mid+1, end);
            }
            else {
                return binarySearch(key, start, mid-1);
            }
        }
        return mid;
    }
}
