import java.util.*;

class Solution {
    private static int idx = 1;
    private static Map<String, Integer> map = new HashMap<>();
    private static char[] wordArr = {'A', 'E', 'I', 'O', 'U'};
    private static final int MAXLENGTH = 5;
    public int solution(String word) {
        find("");
        
        return map.get(word);
    }
    
    private static void find(String word) {
        if (word.length() == MAXLENGTH) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            map.put(word + wordArr[i], idx++);
            find(word + wordArr[i]);
        }
        
    }
}