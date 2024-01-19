import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int maxNode = 0;
        for (int i = 0; i<edges.length; i++) {
            maxNode = Math.max(maxNode, Math.max(edges[i][0], edges[i][1]));
        }
        int[] input = new int[maxNode + 1]; // 들어오는 정점 갯수
        int[] output = new int[maxNode + 1]; // 나가는 정점 갯수
        for (int i = 0; i<edges.length; i++) {
            output[edges[i][0]]++;
            input[edges[i][1]]++;
        }
        
        int[] answer = new int[4];
        for (int i = 1; i<= maxNode; i++) {
            if (output[i] == 0) {
                answer[2]++;
            }
            
            if (output[i] >= 2 && input[i] == 0) {
                answer[0] = i;
            }
            
            if (output[i] == 2 && input[i] >= 2) {
                answer[3]++;
            }
        }
        
        answer[1] = output[answer[0]] - (answer[2] + answer[3]);
        return answer;
    }
}