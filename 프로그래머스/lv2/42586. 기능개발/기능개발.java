import java.util.*;

class Solution {
    //배포는 하루에 한번만 가능
    //
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[speeds.length];

        
        for (int i = 0; i<days.length; i++) {
            int tmp = 100 - progresses[i];
            int remaining = 0;
            if(tmp%speeds[i]==0) {
                remaining = tmp / speeds[i];
            }
            else {
                remaining = tmp / speeds[i] + 1;
            }
            days[i] = remaining;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        queue.add(days[0]);
        
        for (int i = 1; i<days.length; i++) {
            if(days[i] > queue.peek()) {
                list.add(queue.size());
                queue.clear();
                queue.add(days[i]);
            }
            else {
                queue.add(days[i]);
            }
            
            if(i == days.length - 1) {
                    list.add(queue.size());
                }
            
        }
        
        int[] ans = new int[list.size()];
        for (int i = 0; i<ans.length; i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}