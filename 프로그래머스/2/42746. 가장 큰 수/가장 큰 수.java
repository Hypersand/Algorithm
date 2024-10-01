import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            String value = String.valueOf(numbers[i]);
            
            int t = 0;
            while(value.length() < 4) {
                value += value.charAt(t);
                t++;
                if (t >= value.length()) t = 0;
            }
            list.add(new Node(i, numbers[i], Integer.parseInt(value)));
        }
        
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        
        boolean isZero = true;
        
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).originValue);
            if (list.get(i).originValue != 0) isZero = false;
        }
        
        if (isZero) return "0";
        
        return sb.toString();
    }
    
    private static class Node implements Comparable<Node> {
        private int idx;
        private int originValue;
        private int value;
        
        private Node(int idx, int originValue, int value) {
            this.idx = idx;
            this.originValue = originValue;
            this.value = value;
        }
        
        public int compareTo(Node node) {
            if (this.value == node.value) {
                return this.originValue - node.originValue;
            }
            return node.value - this.value;
        }
    }
}