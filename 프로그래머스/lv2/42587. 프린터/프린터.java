import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        int max = 0;
        int answer = 0;
        int [] arr = new int[priorities.length];
        
        for (int i = 0; i < priorities.length; i++) {
            arr[i] = priorities[i];
            queue.add(priorities[i]);
        }
        
        Arrays.sort(arr);
        int k = arr.length-1;
        max = arr[k];
        int count = 0;
        
        int i = location;
        while(true) {
            if(queue.peek()<max) {
                queue.add(queue.poll());
                if(i==0) i+= queue.size()-1;
                else i--;
            }
            else {
                if(i==0) {
                    answer = count+1;
                    break;
                }
                else {
                    queue.poll();
                    max = arr[--k];
                    i--;
                    count++;
                }
            }
        }
        
        return answer;
        
    }
}