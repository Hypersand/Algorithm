import java.util.*;
class Solution {
    private static Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        //각 주문별 알파벳 오름차순 정렬
        for (int i = 0; i<orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            String order = "";
            for (int j = 0; j<arr.length; j++) {
                order += arr[j];
            }
            orders[i] = order;
        }
        
        List<String> list = new ArrayList<>();
        
        //코스 길이만큼 각 주문 조합
        for (int i = 0; i<course.length; i++) {
            map = new HashMap<>();
            for (int j = 0; j<orders.length; j++) {
                String[] orderArr = orders[j].split("");
                comb(orderArr, course[i], 0, "");
            }
            
            int maxSize = 0;
            for (int value : map.values()) {
                maxSize = Math.max(value, maxSize);
            }
            
            if (maxSize < 2) continue;
            
            for (String str : map.keySet()) {
                if(map.get(str) == maxSize) {
                    list.add(str);
                }
            }
        }
        
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for (int i = 0; i<answer.length; i++) {
            answer[i] = list.get(i);
        } 
        
        return answer;
    }
    
    private static void comb(String[] orderArr, int maxSize, int idx, String str) {
        if (str.length() == maxSize) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }
        
        for (int i = idx; i<orderArr.length; i++) {
            comb(orderArr, maxSize, i + 1, str + orderArr[i]);
        }
        
        
    }
}