import java.util.*;
class Solution {
    private static boolean[] visited;
    public int solution(int[] cards) {
        visited = new boolean[cards.length];
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i<cards.length; i++) {
            if (!visited[i]) {
                scores.add(dfs(i, cards));
            }
        }
        
        Collections.sort(scores);
        if (scores.size() == 1) return 0;
        return  scores.get(scores.size() - 2) * scores.get(scores.size() - 1);
    }
    
    private static int dfs(int idx, int[] cards) {
        if (!visited[idx]) {
            visited[idx] = true;
            return dfs(cards[idx] - 1, cards) + 1;
        }
        return 0;
    }
}