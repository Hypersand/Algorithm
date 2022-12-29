

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int [] arr;
    private static boolean [] used;
    private static int N;
    private static int M;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        used = new boolean[N+1];

        backTracking2(0);

        System.out.println(sb);
    }

    private static void backTracking2(int index) {

        if(index==M) {
            for(int i = 0; i<M; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(index>0&&arr[index-1]>i) continue;
            if(!used[i]) {
                arr[index] = i;
                used[i] = true;
                backTracking2(index+1);
                used[i] = false;
            }
        }
    }
}
