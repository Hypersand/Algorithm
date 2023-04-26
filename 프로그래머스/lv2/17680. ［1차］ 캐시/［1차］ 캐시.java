import java.util.*;

class Solution {
    //총 실행시간
    //cache hit - 1
    //cache miss - 5
    //LRU - least recently used   15 + 1 + 1 + 1 + 1 + 1 + 1 = 21
    // Jeju, Pangyo, Seoul, Jeju, Pangyo, Seoul, Jeju, Pangyo, Seoul
    //캐시 Jeju, Pangyo, Seoul
    //캐시공간을 뭘로 구현할 건지?? 
    public int solution(int cacheSize, String[] cities) {
        
        int runtime = 0;
        
        Set<String> set = new LinkedHashSet<>();
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        
        
        for (int i = 0; i<cities.length; i++) {
            String str = cities[i].toUpperCase();
            
            if(set.size() < cacheSize) {
                if(set.contains(str)) {
                    set.remove(str);
                    set.add(str);
                    runtime += 1;    
                }
                else {
                    set.add(str);
                    runtime += 5;    
                }
                
            } 
            
            else {
                if(set.contains(str)) {
                    set.remove(str);
                    set.add(str);
                    runtime += 1;
                }
                
                else {
                    for (String s : set) {
                        set.remove(s);
                        break;
                    }
                    set.add(str);
                    runtime += 5;
                }
            }
        }
        
        return runtime;
    }
    

}