import java.util.*;
class Solution {
    public String solution(String new_id) {
        //1단계
        new_id = new_id.toLowerCase();
        String id = "";
        //2단계
        for (int i = 0; i<new_id.length(); i++) {
            if((new_id.charAt(i) >= 'a' && new_id.charAt(i) <= 'z') || 
               (new_id.charAt(i) >= '0' && new_id.charAt(i) <= '9') ||
               new_id.charAt(i) == '-' || new_id.charAt(i) == '_' ||
               new_id.charAt(i) == '.') {
                id += String.valueOf(new_id.charAt(i));
            } 
        }
        new_id = id;
        
        new_id = new_id.replaceAll("[.]{2,}", "."); // .2개 이상 .으로 
        new_id = new_id.replaceAll("^[.]|[.]$", ""); // 처음과 끝 . 제거 

        if(new_id.equals("")) // 빈 문자열이라면 a 추가 
            new_id += "a";
            
        if(new_id.length() >= 16){ // 16자 이상이면 15자로 
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("^[.]|[.]$", ""); // 끝 . 제거 
        }
        if(new_id.length() <= 2) // 2자 이하라면 3자까지 마지막 문자추가 
            while(new_id.length() < 3)
                new_id += new_id.charAt(new_id.length() - 1);

        return new_id;
    
    }
}