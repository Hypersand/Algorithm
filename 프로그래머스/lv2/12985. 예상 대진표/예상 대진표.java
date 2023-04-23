import java.util.*;
        //N명이 참가 토너먼트 형식으로 진행
        //(1,2) (3,4) (N-1, N) 끼리 게임 진행
        //다음라운드 참가자 1  - N/2
        //최종 한명이 남을때까지 진행된다.
        //참가자수 n, 참가자 번호 a, b
        //a번과 b번이 만나는 라운드  -> 서로 붙기전까지 항상 이긴다는 가정

class Solution
{
    public int solution(int n, int a, int b)
    {
        
        int count = 1;
      
        for (int i = n; i>=2; i/=2) {
            
            
            if(Math.abs(a-b)==1 && Math.min(a,b)%2==1) {
                break;
            }
            
            
            if (a%2!=0) {
                a = (a+1) / 2;
            }
            else if(a%2==0) {
                a /= 2;
            }
            if (b%2!=0) {
                b = (b+1) / 2;
            }
            else if(b%2==0) {
                b /= 2;
            }
            
            count++;
    
        }
        
        
        return count;
    }
    
    
}