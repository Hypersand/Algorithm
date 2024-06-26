import java.util.*;

// 영재가 실어야 하는 택배상자는 크기가 모두 같다
// 1번 상자부터 n번 상자까지 번호가 증가하는 순서대로 컨테이너 벨트에 일렬로 놓여 영재에게 전달
// 컨테이너 벨트는 한 방향으로만 진행 가능, 벨트에 놓인 순서대로 상자를 내릴 수 있따
// 하지만, 배달 순서와 택배 상자가 실려있는 순서가 맞지 않다
// 택배 기사님이 미리 알려준 순서에 맞게 택배상자를 실어야 한다
// 보조 컨테이너 벨트를 추가로 설치
// 보조 컨테이너 베르는 맨 앞으 상자만 뺄 수 있따(가장 마지막에 보관한 상자부터)
// 보조 컨테이너 벨트를 이용해도 원하는 순서대로 싣지 못하면 더 이상 상자를 싣지 않는다
// 1 2 3 4 5     4 3 1 2 5
// 큐 : 1 ,, 2345
// 큐 : 2 1 ,, 345
// 큐 : 3,2,1 .. 45
// 큐 : 3,2,1 // 5
// 큐 : 2,1 // 5
// 3 2 1 : 보조, 4 3 
class Solution {
    public int solution(int[] order) {
        int containerIdx = 0;
        int startNum = 1;
        int answer = 0;
        Stack<Integer> subContainer = new Stack<>();
        
        while (startNum <= order.length) {
            if (!subContainer.isEmpty() && subContainer.peek() == order[containerIdx]) {
                subContainer.pop();
                answer++;
                containerIdx++;
            }
            
            // 현재 컨테이너의 맨앞의 택배와 order의 택배가 다르먄
            if (startNum != order[containerIdx]) {
                subContainer.push(startNum++);
                continue;
            }
            
            answer++;
            startNum++;
            containerIdx++;
        }
        
        while (!subContainer.isEmpty() && subContainer.peek() == order[containerIdx]) {
                subContainer.pop();
                answer++;
                containerIdx++;
            }
        
        
        return answer;
        
    }
}