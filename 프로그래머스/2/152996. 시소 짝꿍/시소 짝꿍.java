import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] originWeights = new long[1001];
        long[] multipleWeights = new long[4001];
        Arrays.sort(weights);
        for (int i = 0; i<weights.length; i++) {
            answer += originWeights[weights[i]];
            answer += multipleWeights[weights[i]*2] - originWeights[weights[i]];
            answer += multipleWeights[weights[i]*3] - originWeights[weights[i]];
            answer += multipleWeights[weights[i]*4] - originWeights[weights[i]];
            originWeights[weights[i]]++;
            multipleWeights[weights[i] * 2]++;
            multipleWeights[weights[i] * 3]++;
            multipleWeights[weights[i] * 4]++;
        }
        return answer;
    }
}