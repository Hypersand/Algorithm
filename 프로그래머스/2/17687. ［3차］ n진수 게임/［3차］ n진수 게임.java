import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        int num = 0;
        int cnt = 0;
        int k = 0;
        String answer = "";
        List<String> list = new ArrayList<>();
        while (true) {
            String str = String.valueOf(Long.toString(num++, n));
            String[] arr = str.split("");
            for (int i = 0; i<arr.length; i++) {
                list.add(arr[i]);
                if (list.size() == p + (k * m)) {
                    answer += arr[i];
                    cnt++;
                    k++;
                    if (cnt == t) {
                        break;
                    }
                }
            }
            if (cnt == t) break;
        }
        
        return answer.toUpperCase();
    }
}