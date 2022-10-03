

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];

        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        int i = 0;
        int count = 0;
        while (true) {
            int min = Integer.MAX_VALUE;
            int newK = 0;
            for(int j = 0; j<arr.length; j++) {

                if(arr[j]>K) {
                    break;
                }
                if(min > K/arr[j]) {
                    min = K/arr[j];
                    newK = K%arr[j];
                }

            }
            count += min;
            K = newK;
            if(newK == 0) {
                System.out.println(count);
                break;
            }
        }



    }
}
