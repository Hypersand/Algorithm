import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
    
    public int bfs(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] isVisited = new boolean[words.length];
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));
        
        boolean isFinished = false;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            for (int i = 0; i<words.length; i++) {
                if(!isVisited[i] && compareAlphabet(node.start, words[i])) {
                    if(words[i].equals(target)) {
                        answer = node.count + 1;
                        isFinished = true;
                        break;
                    }
                    
                    queue.add(new Node(words[i], node.count + 1));
                    isVisited[i] = true;
                }
            }
            
            if(isFinished) {
                break;
            }
        }
        
        return answer;
    }
    
    public boolean compareAlphabet(String start, String end) {
        int cnt = 0;
        for (int i = 0; i<start.length(); i++) {
            if(start.charAt(i) != end.charAt(i)) {
                cnt++;
            }
            
            if(cnt > 1) {
                return false;
            }
        }
        
        return true;
    }
    
    public static class Node {
        public String start;
        public int count;
        
        public Node(String start, int count) {
            this.start = start;
            this.count = count;
        }
    }
}