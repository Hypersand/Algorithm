import java.util.*;

class Solution {
    private static int[] dx = {1, 0, -1};
    private static int[] dy = {0, 1, -1};
    private static int[][] arr;
    private static int maxCount;
    public int[] solution(int n) {
        arr = new int[n][2 * n - 1];
        for (int i = 1; i<=n; i++) {
            maxCount += i;
        }
        find(n);
        
        int[] answer = new int[maxCount];
        int idx = 0;
        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j<arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    answer[idx++] = arr[i][j];
                }
            }
        }
        
        return answer;
    }
    
    private static void find(int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        
        int dir = 0;
        int cnt = 1;
        int length = 1;
        int maxLength = n;
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if (maxLength <= 0) return;
            arr[cur.x][cur.y] = cnt++;
            if (cnt > maxCount) return;
            
            if (length < maxLength) {
            // 마지막 방향은 maxLength - 1만큼 가고 바꿔야 함.
                if (dir == 2 && length == maxLength - 1) {
                    maxLength -= 3;
                    length = 1;
                    dir = 0;
                    queue.add(new Node(cur.x + 1, cur.y));
                    continue;
                }
                length++;
                queue.add(new Node(cur.x + dx[dir], cur.y + dy[dir]));
                continue;
            }
            // maxLength 만큼 탐색했다면 방향 바꿔주기
            dir += 1;
            length = 2;
            queue.add(new Node(cur.x + dx[dir], cur.y + dy[dir]));
        }
    }
    
    private static class Node {
        private int x;
        private int y;
        private Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}