import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> map = new HashMap<>();
        List[] lists = new ArrayList[id_list.length];
        for (int i = 0; i<id_list.length; i++) {
            map.put(id_list[i], i);
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i<report.length; i++) {
            String[] arr = report[i].split(" ");
            if(!lists[map.get(arr[1])].contains(arr[0])) {
                lists[map.get(arr[1])].add(arr[0]);
            }
        }
        
        int[] answer = new int[id_list.length];
        
        for (int i = 0; i<id_list.length; i++) {
            if(lists[i].size() >= k) {
                for (int j = 0; j<lists[i].size(); j++) {
                    answer[map.get(lists[i].get(j))]++;
                }
            }
        }
        
        return answer;
    }
}