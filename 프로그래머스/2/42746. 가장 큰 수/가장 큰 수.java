import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i< numbers.length; i++) {
            list.add(new Node(String.valueOf(numbers[i])));
        }
        
        Collections.sort(list);
        boolean flag = true;
        
        String answer = "";
        for (int i = 0; i<list.size(); i++) {
            answer += list.get(i).num;
            if (!list.get(i).num.equals("0")) {
                flag = false;
            }
        }
        
        if (flag) {
            return "0";
        }
        return answer;
        
    }
    
    private static class Node implements Comparable<Node> {
        private String num;
        public Node(String num) {
            this.num = num;
        }
        
        @Override
        public int compareTo(Node node) {
            int sum1 = Integer.parseInt(this.num + node.num);
            int sum2 = Integer.parseInt(node.num + this.num); 
            if (sum1 > sum2) {
                return -1;
            } else if (sum1 < sum2) {
                return 1;
            } else {
                return 0;
            }
        }
        
    }
}