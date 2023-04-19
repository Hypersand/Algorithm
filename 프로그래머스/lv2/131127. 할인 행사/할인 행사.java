import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        Map<String, Integer> map = new HashMap<>();
        
        int count = 0;
        
        for (int i = 0; i<want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int i = 0; i< discount.length - 9; i++) {
            Map<String, Integer> dMap = new HashMap<>();
            for (int j = 0; j<10; j++) {
                dMap.put(discount[i+j], dMap.getOrDefault(discount[i+j],0)+1);
            }
            
            boolean isEqual = true;
            
            for (String key : map.keySet()) {
                if(map.get(key) != dMap.get(key)) {
                    isEqual = false;
                    break;
                }
            }
            
            if (isEqual) {
                count++;
            }
        }
        
        return count;
        
    }
}