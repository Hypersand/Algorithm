class Solution {
    public int solution(String s) {
        int answer = 1;
        for (int i = 0; i<s.length() - 1; i++) {
            for (int j = i + 1; j<s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    answer = Math.max(answer, j - i + 1);
                }
            }
        }
        return answer;
    }
    
    private static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        
        return true;
    }
}