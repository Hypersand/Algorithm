import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer= new int[prices.length];
        Stack<Node> stack = new Stack<>();
        
        stack.push(new Node(prices[0], 0));
        
        if(prices.length>1) {
            
            for (int i = 1; i<prices.length; i++) {
            
                while (!stack.isEmpty() && stack.peek().price > prices[i]) {
                    Node node = stack.pop();
                    answer[node.idx] = i - node.idx;
                }
            
                stack.push(new Node(prices[i], i));
            }
            
        }
        
        for (int i = 0; i<answer.length; i++) {
            if (answer[i]!=0) {
                continue;
            }
            answer[i] = answer.length - 1 - i;
        }
        
        
        return answer;
        
    }
    
    public class Node {
        int price;
        int idx;
        
        Node(int price, int idx) {
            this.price = price;
            this.idx = idx;
        }
    }
}