import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int result = remain / speeds[i];
            if (remain % speeds[i] != 0) {
                result += 1;
            }
            
            queue.add(result);
        }
        
        List<Integer> list = new ArrayList<>();
        
        int cnt = 1;
        int max = queue.poll();
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num <= max) {
                cnt++;
                continue;
            }
            
            list.add(cnt);
            max = num;
            cnt = 1;
        }
        
        list.add(cnt);
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}