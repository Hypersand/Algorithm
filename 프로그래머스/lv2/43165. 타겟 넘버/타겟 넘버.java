import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Queue<node> queue = new LinkedList<>();
        queue.add(new node(numbers[0],0));
        queue.add(new node(-numbers[0],0));
        int n = 0;
        int count = 0;
        
        while(!queue.isEmpty()) {
            node a = queue.poll();
            for(int i = 0; i<2; i++) {
                int newNum = 0;
                int newLoc = a.loc + 1;
                if(newLoc>=numbers.length) {
                    break;
                }
                
                if(i == 0) {
                    newNum = a.num + numbers[newLoc];
                }
                else {
                    newNum = a.num - numbers[newLoc];
                }
                
                if(newLoc<numbers.length) {
                    if(newLoc == numbers.length-1&& newNum == target) {
                        count++;
                    }
                    else {
                    queue.add(new node(newNum,newLoc));
                }
                }
                
            }
        }
        
        return count;
    }
}

class node {
    int num;
    int loc;
    
    public node(int num, int loc) {
        this.num = num;
        this.loc = loc;
    }
}