import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        boolean[] visited = new boolean[n+1];
        int N = n;
        int[] answer = new int[n];
        int answerIdx = 0;
        while (n > 1) {
            long tmp = 1;
            for (int i = 2; i<n; i++) {
                tmp *= i;
            }
            long idx = (k - 1) / tmp; //idx 번째 수
            int cnt = -1;
            //현재 사용하지 않은 수 중 idx 번째 수를 찾아야 함.
            for (int i = 1; i<=N; i++) {
                if (!visited[i]) {
                    cnt++;
                    if (cnt == idx) {
                        visited[i] = true;
                        answer[answerIdx++] = i;
                        break;
                    }
                }
            }
            
            k -= idx * tmp;
            n--;
        }
        
        for (int i = 1; i<=N; i++) {
            if (!visited[i]) {
                answer[answerIdx++] = i;
            }
        }
        return answer;
    }
}