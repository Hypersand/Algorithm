import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(distance);
        for (int i = 0; i<rocks.length; i++) {
            list.add(rocks[i]);
        }
        Collections.sort(list);
        
        int start = 0;
        int end = distance;
        while (start <= end) {
            int mid = (start + end) / 2;
            int tmp = 0;
            int dist = 0;
            for (int i = 1; i < list.size(); i++) {
                dist += list.get(i) - list.get(i - 1);
                if (dist < mid) {
                    tmp++;
                } else {
                    dist = 0;
                }
            }
            
            if (tmp > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            
        }
        
        return end;
    }
}