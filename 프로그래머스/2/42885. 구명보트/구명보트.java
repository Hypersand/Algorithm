import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        if (people.length == 1) return 1;
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;
        int answer = 0;
        while (start <= end) {
            if (start == end) {
                answer++;
                break;
            }
            
            if (people[start] + people[end] <= limit) {
                start++;
                end--;
            } else {
                end--;
            }
            answer++;
        }
        
        return answer;
    }
}