import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int [] count = new int[200001];
        int a = nums.length / 2;
        Map<Integer,Integer> map = new HashMap<>();
        
        if(nums.length == 1) {
            return 1;
        }
        
        for(int i = 0; i<nums.length; i++) {
            map.put(nums[i],count[nums[i]]++);
        }
        
        if(map.size()>=a) {
            answer = a;
        }
        if(map.size()<a) {
            answer = map.size();
        }
        
        
        return answer;       
        
    }
}