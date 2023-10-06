import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i<completion.length; i++) {
            if(map.containsKey(completion[i])) {
                map.put(completion[i], map.get(completion[i]) + 1);
            }
            else {
                map.put(completion[i], 1);    
            }
            
        }
        
        for (int i = 0; i<participant.length; i++) {
            if(map2.containsKey(participant[i])) {
                map2.put(participant[i], map2.get(participant[i]) + 1);
            }
            else {
                map2.put(participant[i], 1);    
            }
        }
        
        String answer = participant[0];
        
        //map : 완주자 목록
        //map2 : 참가자 목록
        
        for (int i = 0; i<participant.length; i++) {
            if(!map.containsKey(participant[i])) {
                answer = participant[i];
                break;
            }
            
            if(!map.get(participant[i]).equals(map2.get(participant[i]))) {
                answer = participant[i];
                break;
            }
        }
        
        return answer;
    }
}