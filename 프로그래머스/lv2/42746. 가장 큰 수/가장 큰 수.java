import java.util.*;

class Solution {
    //numbers 의 길이는 10만이하
    // 0이상 1000이하
    //정답이 너무 클 수 있으므로 문자열로 바꿔서 리턴
    //앞자리가 크면 장땡인듯??
    //정렬을 어떻게 할건지??
    public String solution(int[] numbers) {
        
        List<Integer> list = new ArrayList<>();
        
    
        for (int i = 0; i<numbers.length; i++) {
            list.add(numbers[i]);
        }
        
        Collections.sort(list, new Comparator<>() {
            
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                
                String str_sum1 = s1 + s2;
                String str_sum2 = s2 + s1;
                
                int sum1 = Integer.parseInt(str_sum1);
                int sum2 = Integer.parseInt(str_sum2);
                
                return sum2 - sum1;
            }
        });
        
        if(list.get(0).equals(0)) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int k : list) {
            sb.append(k);
        }
         
        return sb.toString();
    }
}