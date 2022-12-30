import java.util.*;
import java.io.*;

public class Main {
    
    private static int N;
    private static int M;
    private static int [] arr;
    private static boolean [] used;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int [N+1];
        used = new boolean [N+1];

        backTracking(0);
        System.out.println(sb);   
    }
    
    private static void backTracking(int index) {
        if(index==M) {
            for(int i = 0; i<M; i++) {
                sb.append(arr[i]+ " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i<=N; i++) {
            arr[index] = i;
            backTracking(index+1);
        }
    }
}