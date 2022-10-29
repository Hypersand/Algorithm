class Solution {
    public double solution(int[] arr) {
        int sum = 0;
        double mean = 0;
        for(int i = 0; i<arr.length; i++) {
            sum += arr[i];
        }
        mean = (double)sum / arr.length;
        return mean;
    }
}