import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            days[i] = (100 - progresses[i]) / speeds[i];
            if (((100 - progresses[i]) % speeds[i]) != 0) days[i]++;
        }
        
        if (days.length == 1) return new int[]{1};
        
        List<Integer> list = new ArrayList<>();
        int k = 0;
        int tmp = 1;
        for (int i = 1; i < days.length; i++) {
            if (days[i] <= days[k]) {
                tmp++;
            } else {
                list.add(tmp);
                k = i;
                tmp = 1;
            }
        }
        
        if (tmp != 1) {
            list.add(tmp);
        } else {
            list.add(1);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}