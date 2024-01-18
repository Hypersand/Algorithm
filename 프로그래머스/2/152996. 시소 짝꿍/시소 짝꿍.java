import java.util.*;
class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights);
        long[] originWeights = new long[1001];
        long[] multipleWeights = new long[4001];
        
        long answer = 0;
        for (int i = 0; i<weights.length; i++) {
            int A = weights[i];
            int B = weights[i] * 2;
            int C = weights[i] * 3;
            int D = weights[i] * 4;
            if (originWeights[A] > 0) {
                answer += originWeights[A];
                answer += multipleWeights[B] - originWeights[A];
                answer += multipleWeights[C] - originWeights[A];
                answer += multipleWeights[D] - originWeights[A];
            } else {
                answer += multipleWeights[B]; 
                answer += multipleWeights[C];
                answer += multipleWeights[D];
            }
            
            originWeights[A]++;
            multipleWeights[B]++;
            multipleWeights[C]++;
            multipleWeights[D]++;
        }
        return answer;
    }
}