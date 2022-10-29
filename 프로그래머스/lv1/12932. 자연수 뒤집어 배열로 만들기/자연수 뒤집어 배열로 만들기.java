class Solution {
    public int [] solution(long n) {
        int [] arr = new int[11];
        int i = 0;
        int count = 0;
        while(n!=0) {
            count++;
            arr[i] = (int)(n%10); 
            n /= 10;
            i++;
        }
        int[] answer = new int [count];
        for(int j = 0; j<count; j++) {
            answer[j] = arr[j];
        }
        return answer;
    }

    }
   
