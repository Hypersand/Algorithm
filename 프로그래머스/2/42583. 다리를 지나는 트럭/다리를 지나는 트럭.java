import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < bridge_length - 1; i++) {
            queue.add(0);
        }
        
        queue.add(truck_weights[0]);
        int curWeight = truck_weights[0];
        int idx = 1;
        int time = 1;
        
        while (!queue.isEmpty()) {
            time++;
            curWeight -= queue.poll();
            
            if (idx >= truck_weights.length) continue;
            if (curWeight + truck_weights[idx] > weight) {
                queue.add(0);
                continue;
            }
            curWeight += truck_weights[idx];
            queue.add(truck_weights[idx++]);   
        }
        
        return time;
    }
}