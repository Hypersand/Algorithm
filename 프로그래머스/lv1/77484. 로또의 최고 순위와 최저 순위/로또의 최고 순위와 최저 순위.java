import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 민우 44 1 0 0 31 25
        // 당첨 31 10 45 1 6 19
        // 최고 :  31 -> 31, 1 -> 1, 0 -> 10, 0 -> 6   : 4개 일치
        // 최저 : 31 -> 31, 1 -> 1, 나머지 다 안 맞음 : 2개 일치
        // 민우가 구매한 로또 번호 : lottos array
        // 당첨 번호 : win_nums array
        // 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return
        

        int zeroCnt = 0;
        int sameNumCnt = 0;
        
        int[] rank = {6,6,5,4,3,2,1};
        
        for (int i = 0; i<lottos.length; i++) {
            
            if(lottos[i]==0) {
                zeroCnt++;
                continue;
            }
            
            for (int j = 0; j<win_nums.length; j++) {
                if(lottos[i]==win_nums[j]) {
                    sameNumCnt++;
                }
            }
        }
        
        int[] result = new int[2];
        result[0] = rank[zeroCnt + sameNumCnt];
        result[1] = rank[sameNumCnt];
        

        return result;
    }
}