import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i<clothes.length; i++) {
            if(!map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1],1);
                list.add(clothes[i][1]);
            }
            else {
                map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);

            }
        }
        
        if(map.size()==1) {
            answer = map.get(clothes[0][1]);
        }
        else {
            for(int i = 0; i<list.size(); i++) {
                answer *= map.get(list.get(i))+1;
            }
            answer -= 1;
        }

        
        return answer;
    }
}