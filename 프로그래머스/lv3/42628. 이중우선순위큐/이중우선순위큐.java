import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        int [] answer = new int[2];
        int max = 0;
        
        for(int i = 0; i<operations.length; i++) {
            if(operations[i].contains("I")) {
                String[] arr = operations[i].split(" ");
                queue.add(Integer.parseInt(arr[1]));
                list.add(Integer.parseInt(arr[1]));
            }
            if(operations[i].contains("D")) {
                Collections.sort(list);
                
                if(queue.isEmpty()) continue;
                
                if(operations[i].equals("D -1")) {
                    queue.remove();
                    list.remove(0);
                }
            
                if(operations[i].equals("D 1")) {
                    queue.remove(list.get(list.size()-1));
                    list.remove(list.size()-1);
                }
                
            }
        }
        
        Collections.sort(list);
        
        if(queue.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }
        
        if(queue.size()==1) {
            answer[0] = list.get(0);
            answer[1] = list.get(0);
        }
        
        if(queue.size()>1) {
            answer[1] = list.get(0);
            answer[0] = list.get(list.size()-1);
        }
        
        return answer;
    }
}