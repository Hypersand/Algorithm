import java.util.*;
class Solution {
    private static boolean[] visited;
    private static Set<Integer> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        permutation(0, user_id, banned_id);
        return set.size();
    }
    
    private static void permutation(int cnt, String[] user_id, String[] banned_id) {
        if (cnt == banned_id.length) {
            int num = (int)Math.pow(10, cnt);
            int answer = 0;
            for (int i = 0; i<visited.length; i++) {
                if (visited[i]) {
                    answer += i * num;
                    num /= 10;
                }
            }
            
            if (!set.contains(answer)) {
                set.add(answer);
            }
            
            return;
        }
        
        
        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && validate(user_id[i], banned_id[cnt])) {
                visited[i] = true;
                permutation(cnt + 1, user_id, banned_id);
                visited[i] = false;
            }
        }
        
    }
    
    private static boolean validate(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) return false;
        
        for (int i = 0; i<userId.length(); i++) {
            if (bannedId.charAt(i) == '*') continue;
            if (userId.charAt(i) != bannedId.charAt(i)) return false;
        }
        
        return true;
    }
}