

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr,key)-lowerbound(arr,key)+" ");
        }
        System.out.println(sb);

    }
    private static int lowerbound(ArrayList<Integer> arr, int target) {
        int begin = 0;
        int end = arr.size();

        while(begin<end) {
            int mid = (begin + end) / 2;

            if(arr.get(mid) >= target) {
                end = mid;
            }
            else {
                begin = mid + 1;
            }
        }
        return begin;
    }
    private static int upperBound(ArrayList<Integer> data, int target) {
        int begin = 0;
        int end = data.size();

        while(begin < end) {
            int mid = (begin + end) / 2;

            if(data.get(mid) <= target) {
                begin = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return begin;
    }


}
