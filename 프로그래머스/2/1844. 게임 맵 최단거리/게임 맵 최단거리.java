import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[][] arr = new int[maps.length][maps[0].length];
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Node> queue = new LinkedList<>();
        int [] dx = {-1,1,0,0};
        int [] dy = {0,0,-1,1};
        queue.add(new Node(0,0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if(nx>=0&&ny>=0&&nx<maps.length&&ny<maps[0].length&&maps[nx][ny]!=0) {
                    if(!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx,ny));
                        arr[nx][ny] = arr[node.x][node.y] + 1;
                    }
                }
            }
        }
        
        if(arr[maps.length-1][maps[0].length-1] == 0) {
            return -1;
        }
        else {
            return arr[maps.length-1][maps[0].length-1]+1;    
        }
        
        
    }
}

class Node {
    int x;
    int y;
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}