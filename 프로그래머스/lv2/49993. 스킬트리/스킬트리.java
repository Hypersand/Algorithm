import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        String[] skillArr = skill.split("");
        
        List skillList = Arrays.asList(skillArr);
        
        int cnt = 0;
        
        for (int i = 0; i<skill_trees.length; i++) {
            int idx = 0;
            boolean canUse = true;
            
            String[] skillTreeArr = skill_trees[i].split("");
            
            for (int j = 0; j<skillTreeArr.length; j++) {
                if(skillList.contains(skillTreeArr[j])) {
                    if(skillArr[idx].equals(skillTreeArr[j])) {
                        idx++;
                    }
                    else {
                        canUse = false;
                        break;
                    }
                }                
            }
            
            if(canUse) {
                cnt++;
            }
        }
        
        
        
        return cnt;
    }
}