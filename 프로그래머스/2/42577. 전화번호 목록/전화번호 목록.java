import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        Set<String> set = new HashSet<>();
        int[] nums = new int[21];
        
        for (int i = 0; i< phone_book.length; i++) {
            nums[phone_book[i].length()]++;
        }
        
        for (int i = 0; i< phone_book.length; i++) {
            for (int j = 1; j <= phone_book[i].length(); j++) {
                if (nums[j] != 0) {
                    String str = phone_book[i].substring(0, j);
                    if (!set.isEmpty() && set.contains(str)) {
                        return false;
                    }
                }
            }
            set.add(phone_book[i]);
        }
        
        return true;
    }
}