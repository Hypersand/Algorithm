import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] stones, int k) {
        int start = 1;
        int end = 200000000;
        while (start <= end) {
            int mid = (start + end) / 2;
            int[] arr = stones.clone();
            for (int i = 0; i<arr.length; i++) {
                if (arr[i] - mid <= 0) {
                    arr[i] = 0;
                    continue;
                } 
                arr[i] -= mid;
            }
            
            //arr 배열이 건널 수 있는 상태인지 확인한다.
            //건널 수 없는 상황 : 0이 k개 이어지면 건널 수 없다.
            int zeroCnt = 0;
            boolean canPass = true;
            for (int i = 0; i<arr.length; i++) {
                if (arr[i] == 0) {
                    zeroCnt++;
                    if (zeroCnt == k) {
                        canPass = false;
                        break;
                    }
                } else {
                    zeroCnt = 0;
                }
            }
            
            //건널 수 없으면 mid 를 줄인다.
            if (!canPass) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return start;
    }
}