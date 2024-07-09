import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 1;
        int minLength = Integer.MAX_VALUE;
        int startIdx = 0;
        int endIdx = 0;
        int sum = sequence[start];
        
        if (sum == k) {
            return new int[]{0, 0};
        }
        
        while (start < end) {
            if (end == sequence.length) {
                if (sum == k) {
                    if (minLength > end - start) {
                        minLength = end - start;
                        startIdx = start;
                        endIdx = end - 1;
                    }
                }
                sum -= sequence[start++];
                continue;
            }
            if (sum > k) {
                sum -= sequence[start++];
            } else if (sum < k) {
                sum += sequence[end++];
            } else {
                if (minLength > end - start) {
                    minLength = end - start;
                    startIdx = start;
                    endIdx = end - 1;
                }
                
                if (end < sequence.length) {
                    sum += sequence[end++];
                } else {
                    end++;
                }
            }
        }
        
        return new int[]{startIdx, endIdx};
    }
}