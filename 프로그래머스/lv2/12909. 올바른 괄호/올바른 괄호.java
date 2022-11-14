import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stk=new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(c==')'){
                  if(stk.isEmpty()){
                    return false;
                }
                stk.pop();
            }else{
                stk.push('(');
            }
        }
        if(stk.isEmpty()){
            return true;
        }
        return false;
    }
}