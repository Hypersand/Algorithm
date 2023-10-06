import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        List<Point> list = new ArrayList<>();
        
        for (int i = 0; i<routes.length; i++) {
            list.add(new Point(routes[i][0], routes[i][1]));
        }
        
        Collections.sort(list);
        
        int count = 1;
        int camera = list.get(0).end;
        
        for (int i = 1; i<routes.length; i++) {
            if(list.get(i).start > camera) {
                count++;
                camera = list.get(i).end;
            }
        }
        

        return count;
    }
}

class Point implements Comparable<Point> {
    public int start;
    public int end;
    
    public Point(int start, int end) {
        this.start = start;
        this.end = end;
    }    
    
    public int compareTo(Point p) {
        return this.end - p.end;
    }
}