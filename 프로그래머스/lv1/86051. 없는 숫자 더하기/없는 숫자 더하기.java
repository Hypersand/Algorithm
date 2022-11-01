class Solution {
    public int solution(int[] numbers) {
        int answer = -1;
        int [] counting = new int [10];
        for (int i = 0; i<numbers.length; i++) {
            counting[numbers[i]]++;
        }

        int sum = 0;
        
        for (int j = 0; j<counting.length; j++) {
            if(counting[j]==0) {
                sum += j;
            }
        }
        
        return sum;
        
    }
}