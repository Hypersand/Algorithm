class Solution {
    public String solution(String[] seoul) {
        String ans = "";
        for(int i = 0; i<seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                 ans = Integer.toString(i);
                break;
                }
        }
        
        return "김서방은 "+ans+"에 있다";
    }
}