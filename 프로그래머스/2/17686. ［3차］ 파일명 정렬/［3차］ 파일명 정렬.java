import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i<files.length; i++) {
            // Head와 Number 구분하기
            int headEndIdx = 0;
            int numberStartIdx = 0;
            int numberLength = 0;
            for (int j = 0; j<files[i].length(); j++) {
                if (files[i].charAt(j) >= '0' && files[i].charAt(j) <= '9') {
                    numberStartIdx = j;
                    headEndIdx = j - 1;
                    break;
                }    
            }
            
            for (int j = numberStartIdx; j < files[i].length(); j++) {
                if (files[i].charAt(j) >= '0' && files[i].charAt(j) <= '9') {
                    numberLength++;
                } else {
                    break;
                }
            }
            
            if (numberLength > 5) {
                numberLength = 5;
            }
            
            // Head : 0 ~ headEndIdx + 1
            String head = files[i].substring(0, headEndIdx + 1);
            // Number : numberStartIdx ~ numberEndIdx + 1
            int number = Integer.parseInt(files[i].substring(numberStartIdx, numberStartIdx + numberLength));
            list.add(new Node(i, head, number));
        }
        
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for (int i = 0; i<answer.length; i++) {
            answer[i] = files[list.get(i).idx];
        }
        
        return answer;
    }
    
    private static class Node implements Comparable<Node> {
        private int idx;
        private String head;
        private int number;
        
        private Node(int idx, String head, int number) {
            this.idx = idx;
            this.head = head;
            this.number = number;
        }
        
        public int compareTo(Node node) {
            if (this.head.toUpperCase().equals(node.head.toUpperCase())) {
                if (this.number == node.number) {
                    return this.idx - node.idx;
                }
                return this.number - node.number;
            }
            
            return this.head.toUpperCase().compareTo(node.head.toUpperCase());
        }
        
        
    }
}