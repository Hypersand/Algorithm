import java.util.*;

public class Solution {
    //K칸을 앞으로 점프 or, 현재거리X2 위치로 순간이동
    //k칸을 점프하면 K만큼의 건전지 사용, 순간이동은 소모 X
    //거리 5 : 0 -> 1 순간이동 2 순간이동 4 -> 5  : 소모량 2
    public int solution(int n) {
        
        //현재 위치에서 두배 했을때 n보다 작거나 같으면 순간이동
        //초과해버리면 그냥 점프
        //숫자가 크면 미리 점프해두고 이후에 계속 순간이동하는게 더 좋을때도 있음
        //이걸 어떻게 파악하냐?
        //
        int idx = 1;
        int count = 1;
        while (n>=2) {
            if(n%2==1) {
                count++;
            }
            n/=2;
            
        }

        return count;
    }
}