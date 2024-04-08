import java.util.*;

class Solution {
    private static String[][] relation_2;
    private static List<Integer> list = new ArrayList<>();
    private static List<String> answerList = new ArrayList<>();
    private static int answer = 0;
    private static int col, row;
    public int solution(String[][] relation) {
        row = relation.length;
        col = relation[0].length;
        relation_2 = new String[row][col];
        for (int i = 0; i<relation.length; i++) {
            relation_2[i] = relation[i].clone();
        }
        
        for (int i = 1; i<=col; i++) {
            comb(0, 0, i);
        }
        
        return answer;
    }
    
    private static void comb(int idx, int cnt, int maxCnt) {
        if (cnt == maxCnt) {
            // 조합으로 뽑은 컬럼들이 유일성, 최소성을 만족하는지 검증한다.
            if (validate()) {
                answer++;
            }
            return;
        }
        
        for (int i = idx; i<col; i++) {
            list.add(i);
            comb(i + 1, cnt + 1, maxCnt);
            list.remove(list.size() - 1);
        }
    }
    
    private static boolean validate() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i<row; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j<list.size(); j++) {
                int tmpCol = list.get(j);
                sb.append(relation_2[i][tmpCol]).append(",");
            }
            set.add(sb.toString());
        }
        
        if (set.size() == row) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i<list.size(); i++) {
                sb.append(list.get(i));
            }
            
            String key = sb.toString();
            
            for (int i = 0; i<answerList.size(); i++) {
                String str = answerList.get(i);
                int cnt = 0;
                for (int j = 0; j < str.length(); j++) {
                    if (key.contains(String.valueOf(str.charAt(j)))) {
                        cnt++;
                    }
                }
                
                if (cnt == str.length()) return false;
            }
            answerList.add(key);
            return true;
        }
        
        return false;
    }
}