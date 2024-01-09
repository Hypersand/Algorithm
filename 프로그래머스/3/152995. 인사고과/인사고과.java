import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        int wanhoSum = wanho[0] + wanho[1];
        Arrays.sort(scores, new Comparator<>() {
            @Override
            public int compare(int[] score1, int[] score2) {
                if (score1[0] == score2[0]) {
                    return score1[1] - score2[1];
                }
                return score2[0] - score1[0];
            }
        });
        int rank = 1;
        int max = scores[0][1];
        for (int i = 0; i<scores.length; i++) {
            //이전까지의 동료 평가 점수의 최대값보다 클 경우
            if (max <= scores[i][1]) {
                max = scores[i][1];
                if (wanhoSum < scores[i][0] + scores[i][1]) {
                    rank++;
                }
                continue;
            }
            
            //이전까지의 동료 평가 점수의 최대값보다 작을 경우 인센티브 제외 대상
            if (scores[0][0] > scores[i][0]) {
                if (scores[i] == wanho) {
                    return -1;
                }   
            }
        }        
        return rank;
    }
    
}