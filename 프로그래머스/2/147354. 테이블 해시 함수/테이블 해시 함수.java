import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        //col번째 값을 기준으로 오름차순, 같다면 기본키 값을 기준으로 내림차순 정렬
        Arrays.sort(data, new Comparator<>(){
            @Override
            public int compare(int[] data1, int[] data2) {
                if (data1[col - 1] == data2[col - 1]) {
                    return data2[0] - data1[0];
                }
                return data1[col - 1] - data2[col - 1];
            }
        });
        
        List<Integer> sumList = new ArrayList<>();
        int answer = 0;
        
        for (int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            for (int j = 0; j<data[i].length; j++) {
                sum += data[i][j] % (i+1);
            }
            answer = sum ^ answer;
        }
        
        
        return answer;
    }
}