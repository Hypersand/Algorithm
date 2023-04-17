import java.util.*;

// class Solution {
//     public String[] solution(int[][] line) {
       
//         List<Node> list = new ArrayList<>();
//         long min_x = Long.MAX_VALUE;
//         long max_x = Long.MIN_VALUE;
//         long min_y = Long.MAX_VALUE;
//         long max_y = Long.MIN_VALUE;
        
//         for (int i = 0; i<line.length-1; i++) {
            
//             long A = line[i][0];
//             long B = line[i][1];
//             long E = line[i][2];
            
//             for (int j = i+1; j<line.length; j++) {
                
//                 long C = line[j][0];
//                 long D = line[j][1];
//                 long F = line[j][2];
        
//                 if (A*D - B*C == 0) {
//                     continue;
//                 }   
                
                
//                 double x = (double)(B*F - E*D) /(A*D - B*C); 
//                 double y = (double)(E*C -A*F) /(A*D - B*C); 
                
//                 if(x%1!=0||y%1!=0) {
//                     continue;
//                 }
                
                
//                 list.add(new Node((long)x,(long)y));
                
//                 min_x = Math.min(min_x, (long)x);
//                 min_y = Math.min(min_y, (long)y);
//                 max_x = Math.max(max_x, (long)x);
//                 max_y = Math.max(max_y, (long)y);              
//             }
//         }
        
//         long height = max_y - min_y + 1;
//         long width = max_x - min_x + 1;
//         String[] answer = new String[(int)height];
//         boolean[][] isStar = new boolean[(int)height][(int)width];
    
//         for(Node n : list) {
//             long new_x = Math.abs(n.x-min_x);
//             long new_y = Math.abs(n.y-max_y);
//             isStar[(int)new_y][(int)new_x] = true;
//         }
        
//         int i = 0;
        
//         for (boolean[] b : isStar) {
//             StringBuilder sb =new StringBuilder();
            
//             for (int j = 0; j<width; j++) {
//                 if(b[j]) {
//                     sb.append("*");
//                 }
//                 else {
//                     sb.append(".");
//                 }
//             }
//             answer[i++] = sb.toString();
//         }

//         return answer;
//     }
// }

// class Node {
//     long x;
//     long y;
    
//     Node(long x, long y) {
//         this.x = x;
//         this.y = y;
//     }
// }

class Solution {
    //그래프가 그려지는 표의 사이즈를 알아내기 위해서
    static long minX = Long.MAX_VALUE;
    static long maxX = Long.MIN_VALUE;
    static long minY = Long.MAX_VALUE;
    static long maxY = Long.MIN_VALUE;
    public String[] solution(int[][] line) {
        List<long[]> xy = new ArrayList<>();
        for(int i=0; i<line.length - 1; i++){
            for(int j=i+1; j<line.length; j++){
                double xd = xValue(line[i], line[j]);
                double yd = yValue(line[i], line[j]);
                if (isInteger(xd, yd)) {
                    Long x = (long)xd;
                    Long y = (long)yd;
                    setMinAndMax(x.longValue(), y.longValue());
                    xy.add(new long[]{x,y});
                }
            }
        }
        String[] result = new String[((int)maxY - (int)minY + 1)];
        Arrays.fill(result, "");
        int index = 0;
        for(long r=maxY; r>=minY; r--){
            for(long c=minX; c<=maxX; c++){
                boolean isAdd = false;
                for(long[] tmp : xy){
                    if(tmp[1]==r && tmp[0] ==c){
                        result[index] += "*";
                        isAdd = true;
                        break;
                    }
                }
                if(!isAdd)
                    result[index] += ".";
            }
            index++;
        }
        return result;
    }
    private static void setMinAndMax(long x, long y) {
        if(minX > x)
            minX = x;
        if(maxX < x)
            maxX = x;
        if(minY > y)
            minY = y;
        if(maxY < y)
            maxY = y;
    }
    public double xValue(int[] line1, int[] line2){
        double adMinusBc = line1[0]*line2[1] - line1[1]*line2[0];
        return (double)((long)line1[1]*line2[2] - line1[2]*line2[1]) / adMinusBc;
    }
    public double yValue(int[] line1, int[] line2){
        double adMinusBc = line1[0]*line2[1] - line1[1]*line2[0];
        return (double)((long)line1[2]*line2[0] - line1[0]*line2[2]) / adMinusBc;
    }
    public boolean isInteger(double x, double y){
        if(x%1.0==0.0 && y%1.0==0.0)
            return true;
        return false;
    }
}