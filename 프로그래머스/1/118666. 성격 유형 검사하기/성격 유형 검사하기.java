import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> map = new HashMap<>();
        map.put("RT", 0);
        map.put("TR", 0);
        map.put("FC", 0);
        map.put("CF", 0);
        map.put("MJ", 0);
        map.put("JM", 0);
        map.put("AN", 0);
        map.put("NA", 0);
        
        for (int i = 0; i<survey.length; i++) {
            if (choices[i] < 4) {
                if (choices[i] == 1) {
                    map.put(survey[i], map.get(survey[i]) + 3);
                } else if (choices[i] == 2) {
                    map.put(survey[i], map.get(survey[i]) + 2);
                } else {
                    map.put(survey[i], map.get(survey[i]) + 1);
                }
            } else {
                String key = String.valueOf(survey[i].charAt(1)) + String.valueOf(survey[i].charAt(0));
                if (choices[i] == 5) {
                    map.put(key, map.get(key) + 1);
                    
                } else if (choices[i] == 6) {
                    map.put(key, map.get(key) + 2);
                    
                } else if (choices[i] == 7) {
                    map.put(key, map.get(key) + 3);
                }
            }
        }
        String answer = "";
        if (map.get("RT") < map.get("TR")) {
            answer += "T";
        } else {
            answer += "R";
        }
        
        if (map.get("CF") < map.get("FC")) {
            answer += "F";
        } else {
            answer += "C";
        }
        
        if (map.get("JM") < map.get("MJ")) {
            answer += "M";
        } else {
            answer += "J";
        }
        
        if (map.get("AN") < map.get("NA")) {
            answer += "N";
        } else {
            answer += "A";
        }
        
        return answer;
    }
}