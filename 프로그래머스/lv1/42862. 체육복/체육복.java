import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
       
        
        for (int i = 0; i<lost.length; i++) {
            for (int j = 0; j<reserve.length; j++) {
                if (lost[i]==reserve[j]) {
                    lost[i] = 0;
                    reserve[j] = 0;
                }
            }
        }
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        boolean[] used1 = new boolean[lost.length];
        boolean[] used2 = new boolean[reserve.length];
        
        for (int i = 0; i<lost.length; i++) {
            
            if (lost[i]==0 || used1[i]) {
                continue;
            }
            
            for (int j = 0; j<reserve.length; j++) {
                
                if(reserve[j]==0 || used2[j]) {
                    continue;
                }
                
                if(Math.abs(lost[i]-reserve[j])==1) {
                    used1[i] = true;
                    used2[j] = true;
                }
            }
        }
        
        int ans1 = 0;
        for (int i = 0; i<lost.length; i++) {
            if(!used1[i] && lost[i]!=0) {
                ans1++;
            }
        }
        
        used1 = new boolean[lost.length];
        used2 = new boolean[reserve.length];
        
        for (int i = lost.length-1; i>=0; i--) {
            
            if (lost[i]==0 || used1[i]) {
                continue;
            }
            
            for (int j = reserve.length-1; j>=0; j--) {
                
                if(reserve[j]==0 || used2[j]) {
                    continue;
                }
                
                if(Math.abs(lost[i]-reserve[j])==1) {
                    used1[i] = true;
                    used2[j] = true;
                }
            }
        }
        
        int ans2 = 0;
        for (int i = 0; i<lost.length; i++) {
            if(!used1[i] && lost[i]!=0) {
                ans2++;
            }
        }
        
        int ans = ans1 > ans2 ? ans2 : ans1;
        
        
        
        return n - ans;
    }
}