import java.util.*;
class Solution {
    public int solution(int n, int k) {
        //1.k진수로 변환
        String res = "";
        while (n > 0) {
            res = n % k + res;
            n /= k;
        }
        String[] arr = res.split("0");
        //2.소수 판별
        int cnt = 0;
        for (int i = 0; i<arr.length; i++) {
            if(arr[i].equals("")) continue;
            if(isPrime(arr[i])) {
                cnt++;
            } 
        }
        return cnt;
    }
    
    public static boolean isPrime(String str) {
        long num = Long.parseLong(str);
        if (num == 1) return false;
        for (int i = 2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}