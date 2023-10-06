import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for (int i = 0; i<moves.length; i++) {
            int idx = moves[i] - 1;
            for (int j = 0; j<board.length; j++) {
                if(board[j][idx]!=0) {
                    if(!stack.isEmpty() && stack.peek() == board[j][idx]) {
                        stack.pop();
                        cnt += 2;
                    } else {
                        stack.push(board[j][idx]);
                    }
                    board[j][idx] = 0;
                    break;
                }
            }
        }
        
        return cnt;
    }
}