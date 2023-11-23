import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i<26; i++) {
            String key = Character.toString('A' + i);
            map.put(key, i + 1);
        }
        String[] arr = msg.split("");
        List<Integer> list = new ArrayList<>();
        int k = 0;
        int idx = 0;
        for (int i = 0; i<arr.length - 1; i+=k) {
            k = 0;
            String word = arr[i];
            for (int j = i+1; j<arr.length; j++) {
                k++;
                String tmp = word;
                word += arr[j];
                if(!map.containsKey(word)) {
                    map.put(word, map.size() + 1);
                    list.add(map.get(tmp));
                    idx = i + k;
                    break;
                }
            }
        }
        
        String str = "";
        for (int i = idx; i<arr.length; i++) {
            str += arr[i];
        }
        list.add(map.get(str));
        
        int[] answer = new int[list.size()];
        for (int i = 0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}