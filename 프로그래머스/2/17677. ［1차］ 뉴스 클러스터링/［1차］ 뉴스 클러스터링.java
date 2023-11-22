import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        String[] arrA = str1.split("");
        String[] arrB = str2.split("");
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        
        for (int i = 1; i<arrA.length; i++) {
            if(!arrA[i-1].matches("^[a-zA-Z]*$") || !arrA[i].matches("^[a-zA-Z]*$")) continue;
            String tmp = arrA[i-1] + arrA[i];
            mapA.put(tmp, mapA.getOrDefault(tmp, 0) + 1);
        }
        for (int i = 1; i<arrB.length; i++) {
            if(!arrB[i-1].matches("^[a-zA-Z]*$") || !arrB[i].matches("^[a-zA-Z]*$")) continue;
            String tmp = arrB[i-1] + arrB[i];
            mapB.put(tmp, mapB.getOrDefault(tmp, 0) + 1);
        }
        
        double intersection = 0;
        double union = 0;
        for (String key : mapA.keySet()) {
            if (mapB.containsKey(key)) {
                intersection += Math.min(mapA.get(key), mapB.get(key));
                union += Math.max(mapA.get(key), mapB.get(key));
            } else {
                union += mapA.get(key);
            }
        }
        
        for(String key : mapB.keySet()) {
            if(!mapA.containsKey(key)) {
                union += mapB.get(key);
            }
        }
        
        if (intersection == 0 && union == 0) {
            return 65536;
        } else {
            double answer = intersection/union * 65536;
            answer = Math.floor(answer);
            return (int)answer;
        }
    }
}