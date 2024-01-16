import java.util.*;
class Solution {
    private static int[] pick;
    private static String[] mineral;
    private static int answer = 200000000;
    public int solution(int[] picks, String[] minerals) {
        pick = new int[picks.length];
        mineral = new String[minerals.length];
        for (int i = 0; i<pick.length; i++) {
            pick[i] = picks[i];
        }
        for (int i = 0; i<mineral.length; i++) {
            mineral[i] = minerals[i];
        }
        
        //minerals / 5 만큼의 길이가 선택할 수 있는 곡괭이의 수
        int sum = 0;
        for (int i = 0; i<picks.length; i++) {
            sum += picks[i];
        }
        int maxCnt = 0;
        if (minerals.length / 5 != 0) {
            maxCnt = minerals.length / 5 + 1;
        } else {
            maxCnt = minerals.length / 5;
        }
        
        if (maxCnt > sum) {
            maxCnt = sum;
        }
        
        search(maxCnt, 0, 0, 0);
        return answer;
    }
    
    private static void search(int maxCnt, int cnt, int cost, int mineralIdx) {
        if (cnt == maxCnt) {
            answer = Math.min(answer, cost);
            return;
        }
        
        for (int i = 0; i<3; i++) {
            if (pick[i] != 0) {
                //곡괭이가 남아있다면 5개를 캔다.
                int tmpCost = getMinerals(i, mineralIdx);
                //곡괭이의 갯수를 1 줄인다.
                pick[i]--;
                int tmpMineralIdx = mineralIdx + 5;
                if (tmpMineralIdx > mineral.length) {
                    tmpMineralIdx = mineral.length;
                }
                //재귀 호출
                search(maxCnt, cnt + 1, cost + tmpCost, tmpMineralIdx);
                pick[i]++;                
            }
        }
    }
    
    private static int getMinerals(int tool, int mineralIdx) {
        int cost = 0;
        //5개만 캘 수 있다.
        int maxIdx = mineralIdx + 5;
        //미네랄의 갯수를 넘어서면 미네랄의 최대 길이로 맞춰주기
        if (maxIdx > mineral.length) {
            maxIdx = mineral.length;
        }
        for (int i = mineralIdx; i< maxIdx; i++) {
            if (tool == 0) {
                if (mineral[i].equals("diamond")) {
                    cost += 1;
                } else if (mineral[i].equals("iron")) {
                    cost += 1;
                } else {
                    cost += 1;
                }
                continue;
            }
            
            if (tool == 1) {
                if (mineral[i].equals("diamond")) {
                    cost += 5;
                } else if (mineral[i].equals("iron")) {
                    cost += 1;
                } else {
                    cost += 1;
                }
                continue;
            }
            
            if (mineral[i].equals("diamond")) {
                cost += 25;
            } else if (mineral[i].equals("iron")) {
                cost += 5;
            } else {
                cost += 1;
            }
        }
        
        return cost;
    }
}