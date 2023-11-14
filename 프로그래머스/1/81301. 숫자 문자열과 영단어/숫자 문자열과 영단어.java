class Solution {
    public int solution(String s) {
        String[] strNums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        
        int t = 0;
        while (t < 10) {
            if (s.contains(strNums[t])) {
                s = s.replaceAll(strNums[t], nums[t]);
            }
            t++;
        }
        
        return Integer.parseInt(s);
    }
}