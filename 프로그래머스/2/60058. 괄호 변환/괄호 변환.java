import java.util.*;
class Solution {
    public String solution(String p) {
        if(validateStr(p)) {
            return p;
        }
        
        return changeStr(p);
    }
    
    private static String changeStr(String str) {
        if (str.equals("")) return "";
        String[] arr = str.split("");
        int openBracketCnt = 0;
        int closeBracketCnt = 0;
        String u = "";
        String v = "";
        for (int i = 0; i<arr.length; i++) {
            if (arr[i].equals("(")) openBracketCnt++;
            if (arr[i].equals(")")) closeBracketCnt++;
            if (openBracketCnt == closeBracketCnt) {
                u = str.substring(0, i + 1);
                if (i + 1 < arr.length) {
                    v = str.substring(i + 1);
                }
                break;
            }
        }
        
        //u가 올바른 문자열이라면
        if (validateStr(u)) {
            //v에 대해 1단계부터 다시 수행
            v = changeStr(v);
        } 
        //u가 올바른 문자열이 아니라면
        else {
            //문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙인다.
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(changeStr(v)).append(")");
            for (int i = 1; i<u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    sb.append(")");
                } else {
                    sb.append("(");
                }
            }
            return sb.toString();
        }
        
        return u + v;
    }
    
    
    private static boolean validateStr(String str) {
        String[] arr = str.split("");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i<arr.length; i++) {
            if (arr[i].equals("(")) {
                stack.push("(");
            } else {
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                    continue;
                }
                stack.push(")");
            }
        }
        
        //올바른 문자열
        if (stack.isEmpty()) {
            return true;
        }
        
        return false;
    }
}