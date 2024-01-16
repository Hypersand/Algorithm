import java.util.*;
class Solution {
    private static String[] userIdArr;
    private static String[] bannedIdArr;
    private static boolean[] used;
    private static List<List<Integer>> lists = new ArrayList<>();
    private static int cnt = 0;
    public int solution(String[] user_id, String[] banned_id) {
        userIdArr = new String[user_id.length];
        bannedIdArr = new String[banned_id.length];
        used = new boolean[user_id.length];
        for (int i = 0; i<user_id.length; i++) {
            userIdArr[i] = user_id[i];
        }
        for (int i = 0; i<banned_id.length; i++) {
            bannedIdArr[i] = banned_id[i];
        }
        search(0);
        return cnt;
    }
    
    private static void search(int bannedIdx) {
        if (bannedIdx == bannedIdArr.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i<used.length; i++) {
                if (used[i]) {
                    list.add(i);
                }
            }
            if (!lists.contains(list)) {
                lists.add(list);
                cnt++;
            }
            return;
        }
        
        for (int i = 0; i<userIdArr.length; i++) {
            if(validate(userIdArr[i], bannedIdArr[bannedIdx])) {
                if (!used[i]) {
                    used[i] = true;
                    search(bannedIdx + 1);
                    used[i] = false;
                }
            }
        }
    }
    
    private static boolean validate(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }
        
        for (int i = 0; i<bannedId.length(); i++) {
            if (bannedId.charAt(i) == '*') {
                continue;
            }
            if (userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}