import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        return bfs(numbers, target, numbers[0]) + 
            bfs(numbers, target, numbers[0]*(-1));
    }
    
    public int bfs(int[] numbers, int target, int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, start));
        int count = 0;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if(node.index == numbers.length) {
                if(node.result == target) {
                    count++;
                }
            }
            
            else {
                queue.add(new Node(node.index+1,node.result+numbers[node.index]));
                queue.add(new Node(node.index+1,node.result-numbers[node.index]));
            }
        }
        return count;
    }
}

class Node {
    public int index;
    public int result;
    
    public Node(int index, int result) {
        this.index = index;
        this.result = result;
    }   
}