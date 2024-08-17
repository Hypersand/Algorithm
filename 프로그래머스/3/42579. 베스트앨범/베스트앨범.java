import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Music> musics = new ArrayList<>();
        for (String key : map.keySet()) {
            musics.add(new Music(key, map.get(key)));
        }
        
        Collections.sort(musics);
        int t = 0;
        
        List<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i<musics.size(); i++) {
            Music music = musics.get(i);
            List<Node> list = new ArrayList<>();
            for (int j = 0; j<genres.length; j++) {
                if (music.genre.equals(genres[j])) {
                    list.add(new Node(j, plays[j]));
                }
                
            }
            
            Collections.sort(list);
            for (int j = 0; j<list.size(); j++) {
                if (j > 1) break;
                answerList.add(list.get(j).idx);
            }
        }
        
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    private static class Music implements Comparable<Music> {
        private String genre;
        private int play;
        
        private Music(String genre, int play) {
            this.genre = genre;
            this.play = play;
        }
        
        public int compareTo(Music music) {
            return music.play - this.play;
        }
    }
    
    private static class Node implements Comparable<Node> {
        private int idx;
        private int play;
        
        private Node(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
        
        public int compareTo(Node node) {
            if (this.play == node.play) {
                return this.idx - node.idx;
            }
            
            return node.play - this.play;
        }
    }
}