import java.util.*;

class Solution {

    public String[] words = {"A","E","I","O","U"};
    public int answer = 0;
    public int count = 0;
    public List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        
        for (int i = 0; i<5; i++) {
            makeWord(words[i]);    
        }
        
        int answer = 0;
        
        for (int i = 0; i<list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
    
    
    public void makeWord(String str) {
        if(str.length() > 5) {
            return;
        }
        
        if(!list.contains(str)) {
            list.add(str);
        }
        
        
        for (int i = 0; i<5; i++) {
            makeWord(str+words[i]);
        } 
        
    }
}