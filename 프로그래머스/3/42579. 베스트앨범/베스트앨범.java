import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        Map<String, Integer> totalPlayMap = new HashMap<>();
        Map<String, Integer> cntMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            totalPlayMap.put(genres[i], totalPlayMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        PriorityQueue<Music> pq = new PriorityQueue<>();
        
        for (int i = 0; i < genres.length; i++) {
            pq.add(new Music(i, totalPlayMap.get(genres[i]), plays[i]));
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        while(!pq.isEmpty()) {
            Music music = pq.poll();
            if (cntMap.get(genres[music.idx]) != null && cntMap.get(genres[music.idx]) == 2) continue;
            cntMap.put(genres[music.idx], cntMap.getOrDefault(genres[music.idx], 0) + 1);
            answerList.add(music.idx);
        }
        
        return answerList;
    }
    
    private static class Music implements Comparable<Music> {
        private int idx;
        private int genrePlay;
        private int play;
        
        private Music(int idx, int genrePlay, int play) {
            this.idx = idx;
            this.genrePlay = genrePlay;
            this.play = play;
        }
        
        public int compareTo(Music music) {
            if (this.genrePlay == music.genrePlay) {
                if (this.play == music.play) {
                    return this.idx - music.idx;
                }
                return music.play - this.play;
            }
            
            return music.genrePlay - this.genrePlay;
        }
    }
}