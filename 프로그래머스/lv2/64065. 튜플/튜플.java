import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> list = new ArrayList<>();
        s = s.substring(2,s.length());
        s = s.substring(0,s.length()-2).replace("},{","-");
        String [] arr = s.split("-");
        
        Arrays.sort(arr,new Comparator<String>(){
            public int compare(String o1, String o2){
                
                return o1.length()-o2.length();
            }
        });
        
        for(String str : arr) {
            String [] tmp;
            tmp = str.split(",");
            
            for(int j = 0 ; j < tmp.length;j++){
                int n = Integer.parseInt(tmp[j]);
                if(!list.contains(n))  list.add(n);
            }
        }
        
        int [] answer = new int[list.size()];
        for(int k = 0; k<list.size(); k++) {
	        answer[k] = list.get(k).intValue();
        }        
        return answer;
    }
}