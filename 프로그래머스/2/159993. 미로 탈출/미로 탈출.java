import java.util.*;

class Solution {
    private static String[][] arr;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    public int solution(String[] maps) {
        arr = new String[maps.length][maps[0].length()];
        Node start = new Node(0, 0);
        Node lever = new Node(0, 0);
        Node end = new Node(0, 0);
        for (int i = 0; i<maps.length; i++) {
            String[] line = maps[i].split("");
            for (int j = 0; j<line.length; j++) {
                arr[i][j] = line[j];
                if (arr[i][j].equals("S")) {
                    start = new Node(i, j);
                } else if (arr[i][j].equals("E")) {
                    end = new Node(i, j);
                } else if (arr[i][j].equals("L")) {
                    lever = new Node(i, j);
                }
            }
        }
        
        int dist1 = find(start, lever);
        int dist2 = find(lever, end);
        
        if (dist1 == -1 || dist2 == -1) {
            return -1;
        }
        
        return dist1 + dist2;
    }
    
    private static int find(Node start, Node end) {
        int[][] dist = new int[arr.length][arr[0].length];
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        dist[start.x][start.y] = 1;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == end.x && node.y == end.y) break;
            for (int i = 0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length) continue;
                if (arr[nx][ny].equals("X")) continue;
                if (dist[nx][ny] != 0) continue;
                dist[nx][ny] = dist[node.x][node.y] + 1;
                queue.add(new Node(nx, ny));
            }
        }
        
        return dist[end.x][end.y] - 1;    
    }
    
    private static class Node {
        private int x;
        private int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}