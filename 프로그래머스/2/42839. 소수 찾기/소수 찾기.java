import java.util.*;

class Solution {
    private static char[] numCharArr;
    private static boolean[] visited;
    private static int answer = 0;
    private static boolean[] isNotPrime = new boolean[10000000];
    private static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        numCharArr = new char[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            numCharArr[i] = numbers.charAt(i);
        }
        
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(10000000); i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j < 10000000; j += i) {
                    isNotPrime[j] = true;
                }   
            }
            
        }
        
        for (int i = 1; i <= numbers.length(); i++) {
            visited = new boolean[numbers.length()];
            comb("", i);
        }
        
        return answer;
    }
    
    private static void comb(String numStr, int maxLength) {
        if (numStr.length() == maxLength) {
            if (!isNotPrime[Integer.parseInt(numStr)]) {
                if (!set.isEmpty() && set.contains(Integer.parseInt(numStr))) return;
                set.add(Integer.parseInt(numStr));
                answer++;
            }
            return;
        }
        
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            comb(numStr + numCharArr[i], maxLength);
            visited[i] = false;
        }
    }
}