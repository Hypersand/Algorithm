import java.util.*;
class Solution {
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public List<Integer> solution(String[] maps) {
        int row = maps.length;
        int col = maps[0].length();
        map = new int[row][col];
        visited = new boolean[row][col];
        for (int i = 0; i<maps.length; i++) {
            String[] line = maps[i].split("");
            for (int j = 0; j< line.length; j++) {
                if (line[j].equals("X")) {
                    map[i][j] = -1;
                } else {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i< map.length; i++) {
            for (int j = 0; j<map[i].length; j++) {
                if (map[i][j] == -1 || visited[i][j]) continue;
                visited[i][j] = true;
                list.add(bfs(i, j));
            }
        }
        Collections.sort(list);
        if (list.size() == 0) {
            list.add(-1);
            return list;
        }
        return list;
    }
    
    private static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        int sum = map[x][y];
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == -1) continue;
                sum += map[nx][ny];
                queue.add(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }
        return sum;
    }
    
    private static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}