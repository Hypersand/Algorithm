import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            list.add(new HashSet<>());
        }
        
        list.get(1).add(N);
        
        for (int i = 2; i <= 8; i++) {
            String firstValue = "";
            for (int j = 0; j < i; j++) {
                firstValue += N;
            }
            list.get(i).add(Integer.parseInt(firstValue));
            
            for (int j = 1; j < i; j++) {
                int k = i - j;
                for (int key1 : list.get(j)) {
                    for (int key2 : list.get(k)) {
                        list.get(i).add(key1 + key2);
                        if (key1 - key2 != 0) {
                            list.get(i).add(key1 - key2);
                        }
                        
                        if (key1 * key2 != 0) {
                            list.get(i).add(key1 * key2);
                        }
                        
                        if (key2 != 0) {
                            list.get(i).add(key1 / key2);
                        }
                        
                    }
                }
            }
        }
        
        for (int i = 1; i <= 8; i++) {
            if (!list.get(i).isEmpty() && list.get(i).contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}