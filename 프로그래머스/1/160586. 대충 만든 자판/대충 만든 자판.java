import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                String keyword = String.valueOf(keymap[i].charAt(j));
                if (!map.containsKey(keyword)) {
                    map.put(keyword, j + 1);
                    continue;
                }
                
                int count = map.get(keyword);
                if (count > j + 1) {
                    map.put(keyword, j + 1);
                }   
            }
        }
        
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            boolean flag = true;
            for (int j = 0; j < targets[i].length(); j++) {
                String key = String.valueOf(targets[i].charAt(j));
                if (!map.containsKey(key)) {
                    flag = false;
                    break;
                }
                sum += map.get(key);
            }
            
            if (!flag) {
                answer[i] = -1;
                continue;
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}