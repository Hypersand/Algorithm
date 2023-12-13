import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int score = 0;
        int start = 0;
        int end = 0;
        while((start < A.length) && (end < B.length)) {
            if (A[start] >= B[end]) {
                end++;
            } else {
                start++;
                end++;
                score++;
            }
        }
        return score;
    }
}