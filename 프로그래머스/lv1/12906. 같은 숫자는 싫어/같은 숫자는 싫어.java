import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        int [] arr2 = new int [10000001];
        int count = 0;
        for(int i = 0; i<arr.length; i++) {
            
            if(stack.size()>0&&stack.peek() == arr[i]) {
                continue;
            }
            else {
                stack.push(arr[i]);
                arr2[count] = arr[i];
                count++;
            }
        }
        
        int [] answer = new int[count];
        for(int i = 0; i<count; i++) {
            answer[i] = arr2[i];
        }
        
        
        return answer;
    }
}