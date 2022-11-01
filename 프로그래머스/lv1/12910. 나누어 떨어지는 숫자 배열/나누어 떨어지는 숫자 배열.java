import java.util.*; 

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        ArrayList<Integer> array = new ArrayList<>();
        int [] no = {-1};
        int [] answer = {};
        int count = 0;
        
        for(int i = 0; i<arr.length; i++) {
            if(arr[i]%divisor==0) {
                array.add(arr[i]);
                count ++;
            }
        }
        
        if(count==0) {
            return no;
        }
        
        else {
            Collections.sort(array);
            answer = new int[array.size()];
            for (int i = 0; i<answer.length; i++) {
                answer[i] = array.get(i);
            }
        
        }
        
        return answer;
        
    }
}