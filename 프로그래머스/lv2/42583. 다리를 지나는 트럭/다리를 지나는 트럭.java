import java.util.*;

class Solution {
    //모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지
    //다리에 완전히 오르지 않은 트럭의 무게는 무시한다.
    //bridge_length대 올라갈 수 있다.
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        
        int truckSum = 0;  //다리위에 있는 트럭 무게 합
        int cost = 0; //걸린 시간
        int k = 0; 
        
        while (k<truck_weights.length) {
            
            if(queue.isEmpty()) {
                queue.add(truck_weights[k]);
                cost += 1;
                truckSum += truck_weights[k];
                k++;
                continue;
            }
            
            if (queue.size()>=bridge_length) {
                truckSum -= queue.poll();
            }
            
            else {
                if (truckSum + truck_weights[k] > weight) {
                    queue.add(0);
                    cost += 1;
                }
                
                else {
                    queue.add(truck_weights[k]);
                    truckSum += truck_weights[k];
                    cost += 1;
                    k++;
                }  
            }          
        }
        
        return cost + bridge_length;
        
    }
}