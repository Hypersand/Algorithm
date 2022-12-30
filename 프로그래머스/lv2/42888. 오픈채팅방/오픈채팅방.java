import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        String [] arr;
        String ans;
        
        for(String s : record) {
            if(s.contains("Enter")) {
                arr = s.split(" ");
                map.put(arr[1],arr[2]);
                ans = "입장" + arr[1];
                list.add(ans);
            }
            else if (s.contains("Leave")) {
                arr = s.split(" ");
                ans = "퇴장" + arr[1];
                list.add(ans);
            }
            else {
                arr = s.split(" ");
                map.put(arr[1], arr[2]);
            }
        }
        
        String [] answer = new String[list.size()];
        for(int i = 0; i<answer.length; i++) {
            if(list.get(i).contains("입장")) {
                String str = list.get(i).substring(2);
                answer[i] = map.get(str) + "님이 들어왔습니다.";
            }
            else {
                String str = list.get(i).substring(2);
                answer[i] = map.get(str) + "님이 나갔습니다.";
                
            }
        }
        
        return answer;
    }
}