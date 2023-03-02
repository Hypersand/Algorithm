import java.util.*;

class Solution {

    public String[] words = {"A","E","I","O","U"};
    public List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        
        makeWord("",0);
        
        int answer = 0;
        
        for (int i = 0; i<list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    
    public void makeWord(String str, int length) {
        if(length > 5) {
            return;
        }
        
        if(!list.contains(str)) {
            list.add(str);
        }
        
        
        for (int i = 0; i<5; i++) {
            makeWord(str+words[i],length+1);
        } 
        
    }
}