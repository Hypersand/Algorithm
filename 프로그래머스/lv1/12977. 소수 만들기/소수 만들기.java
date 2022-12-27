class Solution {
    public int solution(int[] nums) {
        boolean [] arr = new boolean[3001];
        int count = 0;
        
        arr[1] = true;
        
        for(int i = 2; i<Math.sqrt(arr.length); i++) {
            for(int j = i*2; j<arr.length; j+=i) {
                if(arr[j]==false) arr[j] = true;
            }
        }
        
        for(int i = 0; i<nums.length-2; i++) {
            for(int j = i+1; j<nums.length-1; j++) {
                for(int k = j+1; k<nums.length; k++) {
                    if(arr[nums[i]+nums[j]+nums[k]]==false) {
                        count++;
                    }
                }
            }
        }
        
        return count;
        

    }
}