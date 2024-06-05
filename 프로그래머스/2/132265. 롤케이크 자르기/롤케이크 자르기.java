import java.util.*;

class Solution {
    public int solution(int[] topping) {
        boolean[] visited = new boolean[10001];
        int[] lArr = new int[topping.length];
        int[] rArr = new int[topping.length];
        
        lArr[0] = 1;
        visited[topping[0]] = true;
        for (int i = 1; i < topping.length; i++) {
            if (!visited[topping[i]]) {
                visited[topping[i]] = true;
                lArr[i] = lArr[i - 1] + 1;
                continue;
            }
            
            lArr[i] = lArr[i - 1];
        }
           
        visited = new boolean[10001];
        rArr[topping.length - 1] = 1;
        visited[topping[topping.length - 1]] = true;
        for (int i = topping.length - 2; i >= 0; i--) {
            if (!visited[topping[i]]) {
                visited[topping[i]] = true;
                rArr[i] = rArr[i + 1] + 1;
                continue;
            }
            
            rArr[i] = rArr[i + 1];
        }
        
        int answer = 0;
        
        for (int i = 0; i < topping.length - 1; i++) {
            if (lArr[i] == rArr[i + 1]) {
                answer++;
            }
        }
        
        
        return answer;
    }
}