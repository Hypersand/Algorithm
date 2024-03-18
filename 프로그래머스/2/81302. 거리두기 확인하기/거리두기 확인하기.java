import java.util.*;
class Solution {
    private static String[][] map;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i<places.length; i++) {
            List<Node> players = new ArrayList<>();
            map = new String[5][5];
            for (int j = 0; j<5; j++) {
                String[] line = places[i][j].split("");
                for (int k = 0; k<5; k++) {
                    map[j][k] = line[k];
                    if (line[k].equals("P")) {
                        players.add(new Node(j, k));
                    }
                    
                }
            }
            
            if (players.size() == 0) {
                answer[i] = 1;
                continue;
            }
            
            if (validate(players)) {
                answer[i] = 1;
            }
        }
        
        return answer;
    }
    
    
    private static boolean validate(List<Node> players) {
        for (int i = 0; i <players.size() - 1; i++) {
            Node node1 = players.get(i);
            for (int j = i + 1; j<players.size(); j++) {
                Node node2 = players.get(j);
                if (Math.abs(node1.x - node2.x) + Math.abs(node1.y - node2.y) > 2) continue;
                //두 플레이어간 맨해튼 거리가 2이하면 bfs를 통해 거리두기 잘 지키고 있는지 검증한다.
                if (!bfs(node1, node2)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static boolean bfs(Node start, Node end) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        queue.add(start);
        visited[start.x][start.y] = true;
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny].equals("X")) continue;
                if (map[nx][ny].equals("P")) {
                    if (Math.abs(start.x - nx) + Math.abs(start.y - ny) <= 2) {
                        return false;
                    }
                    continue;
                }
                
                if (Math.abs(start.x - nx) + Math.abs(start.y - ny) <= 2) {
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return true;
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
