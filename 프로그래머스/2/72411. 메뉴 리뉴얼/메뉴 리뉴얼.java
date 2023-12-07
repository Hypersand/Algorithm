import java.util.*;
import java.util.Map.Entry;
class Solution {
    private static Map<String, Integer> map;
    private static boolean[] used;
    public List<String> solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i<orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        for (int i = 0; i<course.length; i++) {
            map = new HashMap<>();
            for (int j = 0; j<orders.length; j++) {
                used = new boolean[orders[j].length()];
                select(course[i], 0, 0, "", orders[j].split(""));
            }
            Queue<String> queue = new LinkedList<>();
            int max = 0;
            for(Entry<String,Integer> entry : map.entrySet()){
                max = Math.max(max,entry.getValue());   
            }
            
            for(Entry<String,Integer> entry : map.entrySet()) {
                if(max >=2 && entry.getValue() == max) {
                    list.add(entry.getKey());
                }
            }
        }
        
        Collections.sort(list);
        return list;
    }
    
    public static void select(int maxSize, int size, int idx, String tmp, String[] arr) {
        if (size == maxSize) {
            char[] charArr = tmp.toCharArray();
            Arrays.sort(charArr);
            tmp = String.valueOf(charArr);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            return;
        }
        
        for (int i = idx; i<arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                select(maxSize, size + 1, i + 1, tmp + arr[i], arr);
                used[i] = false;
            }
            
        }
        
    }
}