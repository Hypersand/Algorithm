import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int[] myGrade = scores[0];
        int mySum = scores[0][0] + scores[0][1];
        Arrays.sort(scores, new Comparator<>(){
            @Override
            public int compare(int[] score1, int[] score2) {
                if (score2[0] == score1[0]) {
                    return score1[1] - score2[1];
                }
                return score2[0] - score1[0];
            }
        });
           
        int max = 0;
        int rank = 1;
        for (int i = 0; i<scores.length; i++) {
            if (max > scores[i][1]) {
                if (scores[i] == myGrade) return -1;
                continue;
            }
            
            if (scores[i][0] + scores[i][1] > mySum) {
                rank++;
            }
            max = scores[i][1];
            
        }
        return rank;
    }
}