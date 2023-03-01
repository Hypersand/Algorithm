import java.util.*;

class Solution {
    
    public int count = 0;
    public boolean[] isPrime;
    public boolean[] isPossible;
    
    public int solution(String numbers) {
        isPrime = new boolean[(int)Math.pow(10,numbers.length())];
        isPossible = new boolean[isPrime.length];
        
        String[] num = numbers.split("");
        Arrays.fill(isPossible,true);
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i<Math.sqrt(isPrime.length); i++ ) {
            for (int j = i*2; j<isPrime.length; j+=i) {
                isPrime[j] = false;
            }    
            
        }
        
        for (int i = 1; i<=numbers.length(); i++) {
            boolean[] used = new boolean[num.length];
            findPrime(0, used, num, i, "");
        }
        
        
        return count;
    }
    
    public void findPrime(int index, boolean[] used, String[] num, int n, String ans) {
        if(n==0) {
            if(ans.equals("")) {
                return;
            }
            
            if(isPrime[Integer.parseInt(ans)]&&isPossible[Integer.parseInt(ans)]) {
                isPossible[Integer.parseInt(ans)] = false;
                count++;
            }
            
            return;
        }
        
        
        for (int i = 0; i<num.length; i++) {
            if(!used[i]) {
                used[i] = true;
                ans += num[i];
                findPrime(i+1,used,num,n-1, ans);
                ans = ans.substring(0,ans.length()-1);
                used[i] = false;
            }
        }
        
    }
}

