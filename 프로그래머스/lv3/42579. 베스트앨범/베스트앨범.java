import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i<genres.length; i++) {
            if(map.containsKey(genres[i])) {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
                continue;
            }
            
            map.put(genres[i], plays[i]);            
        }
        
        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        List<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i < keyList.size(); i++) {
            String genre = keyList.get(i);
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int j = 0; j < genres.length; j++) {
                if(genre.equals(genres[j])) {
                    pq.add(new Node(j, plays[j]));
                }
            }
            
            if(pq.size() == 1) {
                answerList.add(pq.poll().index);
                continue;
            }
            
            if(pq.size() > 1) {
                for (int j = 0; j<2; j++) {
                    answerList.add(pq.poll().index);
                }   
            }
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static class Node implements Comparable<Node> {
        int index;
        int plays;
        
        public Node(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }
        
        @Override
        public int compareTo(Node n1) {
            if (n1.plays == this.plays) {
                return this.index - n1.index;
            }
            
            return n1.plays - this.plays;       
        }
    }
}