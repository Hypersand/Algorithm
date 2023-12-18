import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int result = A * B * C;
        String[] arr = String.valueOf(result).split("");
        int[] nums = new int[10];
        for (int i = 0; i<arr.length; i++) {
            nums[Integer.parseInt(arr[i])]++;
        }

        for (int i = 0; i<10; i++) {
            System.out.println(nums[i]);
        }
        
    }
}