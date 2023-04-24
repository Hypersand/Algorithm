import java.util.*;

class Solution {
    //귤 중 k개를 골라 상자 하나에 담아 판매
    //귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화
    //귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }
        
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
             public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
             }
        });
        
        int cnt = 0;
        
        for (Map.Entry<Integer,Integer> entry : list) {
            if (entry.getValue() >= k) {
                cnt++;
                break;
            }
            
            else {
                cnt++;
                k -= entry.getValue();
            }
        }
        
        return cnt;
    }
    
    public class fruit {
        int idx;
        int count;
    }
}