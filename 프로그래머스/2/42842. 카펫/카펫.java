import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int[] result = new int[2];
        
        // 가로를 결정
        for (int i = total - 1; i > 1; i--) {
            if (total % i == 0) {
                int width = i;
                int height = total / i;
                
                if (height > width) break;
                if (height <= 2) continue;
                int brownCnt = width * 2 + (height - 2) * 2;
                int yellowCnt = total - brownCnt;
                
                if (brown == brownCnt && yellow == yellowCnt) {
                    result[0] = width;
                    result[1] = height;
                    break;
                }
            }
        }
        
        return result;
    }
}


