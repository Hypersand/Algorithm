import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (s1, s2) -> s1.length() - s2.length());
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j <= phone_book[i].length(); j++) {
                String key = phone_book[i].substring(0, j);
                if (set.contains(key)) return false;
            }
            set.add(phone_book[i]);
        }
        
        return true;
    }
}