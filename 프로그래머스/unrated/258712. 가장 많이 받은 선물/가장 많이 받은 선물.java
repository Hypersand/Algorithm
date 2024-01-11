import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[][] arr = new int[friends.length][friends.length];
        int[] presentGrade = new int[friends.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i<friends.length; i++) {
            map.put(friends[i], i);
        }
        
        for (int i = 0; i<gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            String A = gift[0];
            String B = gift[1];
            int aIdx = map.get(A);
            int bIdx = map.get(B);
            arr[aIdx][bIdx]++;
            presentGrade[aIdx]++;
            presentGrade[bIdx]--;
        }
        
        int[] giftArr = new int[friends.length];
        for (int i = 0; i< arr.length - 1; i++) {
            for (int j = i+1; j< arr.length; j++) {
                int aCnt = arr[i][j];
                int bCnt = arr[j][i];
                //i가 j에게 준 선물이 더 많은 경우
                if (aCnt > bCnt) {
                    giftArr[i]++;
                    continue;
                } 
                //j가 i에게 준 선물이 더 많은 경우
                if (aCnt < bCnt) {
                    giftArr[j]++;
                    continue;
                }
                
                //서로 준 선물의 수가 같거나 없는 경우
                //선물지수가 더 큰 사람이 작은 사람으로부터 하나 받는다.
                if (presentGrade[i] > presentGrade[j]) {
                    giftArr[i]++;
                    continue;
                } 
                
                if (presentGrade[i] < presentGrade[j]) {
                    giftArr[j]++;
                } 
            }
        }
        
        int max = 0;
        for (int i = 0; i<arr.length; i++) {
            max = Math.max(giftArr[i], max);
        }
        
        return max;
    }
}