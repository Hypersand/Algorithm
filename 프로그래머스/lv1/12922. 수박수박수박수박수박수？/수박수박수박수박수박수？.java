class Solution {
    public String solution(int n) {
        String watermelon = "수";
        for(int i = 1; i<n; i++) {
            if(i%2 == 0) {
                watermelon += "수";
            }
            else {
                watermelon += "박";
            }
        }
        return watermelon;
    }
}