import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        Arrays.sort(scores, new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                //근무 태도 점수 내림차순, 점수 같으면 동료 평가 점수 오름차순
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        
        int answer = 1;
        int max = 0;
        int wanhoSum = wanho[0] + wanho[1];
        for (int i = 0; i<scores.length; i++) {
            //인센티브 탈락 대상자
            if (scores[i][1] < max) {
                //탈락 대상자가 완호일 경우
                if (scores[i].equals(wanho)) {
                    return -1;
                }
                continue;
            } 
            
            //인센티브 수령 대상자
            max = Math.max(max, scores[i][1]);
            if (wanhoSum < scores[i][0] + scores[i][1]) {
                answer++;
            }
            
        }
        return answer;
    }
}