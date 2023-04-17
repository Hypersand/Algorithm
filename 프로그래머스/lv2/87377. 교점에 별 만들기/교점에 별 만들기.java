import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
       
        List<Node> list = new ArrayList<>();
        long min_x = Long.MAX_VALUE;
        long max_x = Long.MIN_VALUE;
        long min_y = Long.MAX_VALUE;
        long max_y = Long.MIN_VALUE;
        
        for (int i = 0; i<line.length-1; i++) {
            
            long A = line[i][0];
            long B = line[i][1];
            long E = line[i][2];
            
            for (int j = i+1; j<line.length; j++) {
                
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];
        
                if (A*D - B*C == 0) {
                    continue;
                }   
                
                
                double x = (double)(B*F - E*D) /(A*D - B*C); 
                double y = (double)(E*C -A*F) /(A*D - B*C); 
                
                if(x%1!=0||y%1!=0) {
                    continue;
                }
                
                
                list.add(new Node((long)x,(long)y));
                
                min_x = Math.min(min_x, (long)x);
                min_y = Math.min(min_y, (long)y);
                max_x = Math.max(max_x, (long)x);
                max_y = Math.max(max_y, (long)y);              
            }
        }
        
        long height = max_y - min_y + 1;
        long width = max_x - min_x + 1;
        String[] answer = new String[(int)height];
        boolean[][] isStar = new boolean[(int)height][(int)width];
    
        for(Node n : list) {
            long new_x = Math.abs(n.x-min_x);
            long new_y = Math.abs(n.y-max_y);
            isStar[(int)new_y][(int)new_x] = true;
        }
        
        int i = 0;
        
        for (boolean[] b : isStar) {
            StringBuilder sb =new StringBuilder();
            
            for (int j = 0; j<width; j++) {
                if(b[j]) {
                    sb.append("*");
                }
                else {
                    sb.append(".");
                }
            }
            answer[i++] = sb.toString();
        }

        return answer;
    }
}

class Node {
    long x;
    long y;
    
    Node(long x, long y) {
        this.x = x;
        this.y = y;
    }
}