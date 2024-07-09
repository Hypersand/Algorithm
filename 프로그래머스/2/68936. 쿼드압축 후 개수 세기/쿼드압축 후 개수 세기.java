class Solution {
    private static int N;
    private static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        N = arr.length;
        find(0, 0, N, arr);
        return answer;
    }
    
    private static void find(int startRow, 
                             int startCol, 
                             int length, 
                             int[][] arr) {
        
        int zeroCnt = 0;
        int oneCnt = 0;
        boolean isAllSame = true;
        for (int i = startRow; i < startRow + length; i++) {
            for (int j = startCol; j < startCol + length; j++) {
                if (arr[i][j] == 0) {
                    zeroCnt++;
                } else {
                    oneCnt++;
                }
                
                if (zeroCnt > 0 && oneCnt > 0) {
                    isAllSame = false;
                    break;
                }
            }
            
            if (!isAllSame) break;
        }
        
        // 4가지 사각형으로 분리
        if (!isAllSame) {
            length /= 2;
            find(startRow, startCol, length, arr);
            find(startRow + length, startCol, length, arr);
            find(startRow, startCol + length, length, arr);
            find(startRow + length, startCol + length, length, arr);
            return;
        }
        
        if (zeroCnt > 0) {
            answer[0]++;
        } else {
            answer[1]++;
        }
    }
    
    
}