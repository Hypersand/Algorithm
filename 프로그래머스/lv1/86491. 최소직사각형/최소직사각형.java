class Solution {
    public int solution(int[][] sizes) {
        for(int i = 0; i<sizes.length; i++) {
            if(sizes[i][0]<sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        
        int max1 = sizes[0][0];
        int max2 = sizes[0][1];
        for(int j = 0; j<sizes.length-1; j++) {
            if(max1<sizes[j+1][0]) {
                max1 = sizes[j+1][0];
            }
            
            if(max2<sizes[j+1][1]) {
                max2 = sizes[j+1][1];
            }
            
        }
        
        return max1*max2;
    }
}