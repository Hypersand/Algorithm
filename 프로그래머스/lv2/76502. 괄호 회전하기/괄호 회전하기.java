import java.util.*;

class Solution {
    public int solution(String s) {
        
        int cnt = 0;
        
        for (int i = 0; i< s.length(); i++) {
            if(canRotate(s, i)) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    public boolean canRotate(String s, int move) {
        Stack<String> stack = new Stack<>();
        
        if(move > 0) {
            s = s.substring(move) + s.substring(0,move);    
        }
        
        String[] arr = s.split("");
        
        for (int i = 0; i< arr.length; i++) {
            
            if(!stack.isEmpty()&&arr[i].equals(")")&&stack.peek().equals("(")) {
                stack.pop();
                continue;
            }
            
            if(!stack.isEmpty()&&arr[i].equals("]")&&stack.peek().equals("[")) {
                stack.pop();
                continue;
            }
            
            if(!stack.isEmpty()&&arr[i].equals("}")&&stack.peek().equals("{")) {
                stack.pop();
                continue;
            }
            
            stack.push(arr[i]);
            
        }
        
        if(stack.isEmpty()) {
            return true;
        }
        
        return false;
    }
}