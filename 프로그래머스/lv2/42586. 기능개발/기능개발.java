import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int [] day = new int [progresses.length];
                
        for(int i = 0; i<progresses.length; i++) {
            int a = 100 - progresses[i];
            if(a%speeds[i]>0) {
                day[i] = a / speeds[i] + 1;
            }
            else {
                day[i] = a / speeds[i];
            }
            System.out.println(day[i]);
            
            if(!stack.isEmpty() && stack.peek()>=day[i]) {
                list.set(stack.size()-1, list.get(stack.size()-1)+1);
            }
            else {
                stack.push(day[i]);
                // System.out.println(queue.peek());
                list.add(1);
            }
        }
        
        int [] arr = list.stream()
		              .mapToInt(Integer::intValue)
                      .toArray();
        return arr;
    }
}