import java.util.*;

class Solution {
    //AAA -> JAZ 
    //위로 9번 이동 -> J
    //왼쪽으로 한번 이동 -> 마지막 문자로 커서 이동 
    //아래로 한번 이동 -> JAZ 총 9 + 1 + 1 = 11
    // JAZ -> AAA 도 똑같지 않나??
    // JEROEN
    public int solution(String name) {
        int answer = 0;
        char[] arr = name.toCharArray();
        
        int min = arr.length - 1;
        
        for (int i = 0; i<arr.length; i++) {
            char ch = name.charAt(i);
            if ('Z' - arr[i] > arr[i] - 'A') {
                answer += arr[i] -'A';
            }
            
            else {
                answer += 'Z' - arr[i] + 1;
            }
            
            int nextIdx = i + 1;
            
            while (nextIdx < arr.length && arr[nextIdx] == 'A') {
                nextIdx++;
            }
            
            min = Math.min(min, i*2 + (arr.length - nextIdx));
            min = Math.min(min, (arr.length - nextIdx) * 2 + i);
            
        }
        
        return answer + min;
        
        
    }
}
    
//     public int solution(String name) {
        
//         char[] arr = name.toCharArray();
//         int sum = 0;
//         int idx = 0;
        
//         while (true) {
//             if(validate(arr)) {
//                 break;
//             }
                        
//             else if ('Z' - arr[idx] > arr[idx] - 'A') {
//                 sum += arr[idx] -'A';
//                 arr[idx] = 'A';
//             }
            
//             else {
//                 sum += 'Z' - arr[idx] + 1;
//                 arr[idx]  = 'A';
//             }
            
//             int ans = choice(arr, idx);
            
//             if(ans == 0) {
//                 sum++;
//                 idx += 1;
//                 if (idx > arr.length - 1) {
//                     idx = 0;
//                 }
//              }
            
//             else if (ans == 1){
//                 sum++;
//                 idx -= 1;
//                 if (idx < 0) {
//                     idx = arr.length - 1;
//                 }
//             }
            
//             else {
//                 break;
//             }
//         }

//         return sum;
//     }
    
//     public int choice(char[] arr, int idx) {
//         if(validate(arr)) {
//             return -1;
//         }
        
    
//         int leftCnt = 0;
//         int rightCnt = 0;
        
//         int tmpRightIdx = idx + 1;
//         int tmpLeftIdx = idx - 1;
        
//         while (true) {
//             if (tmpRightIdx > arr.length - 1) {
//                 tmpRightIdx = 0;
//             }
            
//             if(arr[tmpRightIdx] != 'A') {
//                 break;
//             }
            
//             if (arr[tmpRightIdx] == 'A') {
//                 rightCnt++;
//                 tmpRightIdx += 1;
//             }
//         }
        
//         while (true) {
//             if (tmpLeftIdx < 0) {
//                 tmpLeftIdx = arr.length - 1;
//             }
            
//             if(arr[tmpLeftIdx] != 'A') {
//                 break;
//             }
            
//             if (arr[tmpLeftIdx] == 'A') {
//                 leftCnt++;
//                 tmpLeftIdx -= 1;
//             }
            
//         }
            
//         return leftCnt > rightCnt ? 0 : 1;
        
//     }
    
    
//     public boolean validate(char[] arr) {
//         for (int i = 0; i<arr.length; i++) {
//             if (arr[i] != 'A') {
//                 return false;
//             }
//         }
        
//         return true;
//     }
// }