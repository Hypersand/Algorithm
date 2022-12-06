class Solution {
    public String solution(int a, int b) {
        String result = "";
        int [] day = {31,29,31,30,31,30,31,31,30,31,30,31};
        String [] month = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        if(a == 1) {
            result = month[b%7];
        }
        else {
            int sum = 0;
            for (int i = 0; i<a-1; i++) {
                sum += day[i];
            }
            sum += b;
            result = month[sum%7];
        }
        
        
        return result;
    }
}