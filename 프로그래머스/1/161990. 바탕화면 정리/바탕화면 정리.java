import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        char[][] arr = new char[wallpaper.length][wallpaper[0].length()];
        int leftCol = Integer.MAX_VALUE;
        int rightCol = 0;
        int highRow = Integer.MAX_VALUE;
        int lowRow = 0;
        for (int i = 0; i<arr.length; i++) {
            for (int j = 0; j<arr[i].length; j++) {
                arr[i][j] = wallpaper[i].charAt(j);
                if (arr[i][j] == '#') {
                    leftCol = Math.min(leftCol, j);
                    rightCol= Math.max(rightCol, j);
                    highRow = Math.min(highRow, i);
                    lowRow = Math.max(lowRow, i);
                }
            }
        }
        
        return new int[]{highRow, leftCol, lowRow + 1, rightCol + 1};
    }
}