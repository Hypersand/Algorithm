import java.util.*;
class Solution {
    private static int n;
    private static int[] discounts = {10, 20, 30, 40};
    private static int[] emoticonArr;
    private static int[][] userArr;
    private static int maxCnt = 0;
    private static int maxPrice = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        n = emoticons.length;
        userArr = new int[users.length][users[0].length];
        emoticonArr = new int[n];
        for (int i = 0; i<users.length; i++) {
            userArr[i] = users[i].clone();
        }
        for (int i = 0; i<n; i++) {
            emoticonArr[i] = emoticons[i];
        }
        setDiscount(0, 0, "");
        int[] answer = new int[2];
        answer[0] = maxCnt;
        answer[1] = maxPrice;
        return answer;
    }
    
    private static void setDiscount(int idx, int cnt, String str) {
        if (cnt == n) {
            calculate(str);
            return;
        }
        
        for (int i = idx; i<n; i++) {
            for (int j = 0; j<4; j++) {
                setDiscount(i + 1, cnt + 1, str + " " + discounts[j]);
            }
        }
    }
    
    private static void calculate(String str) {
        String[] arr = str.split(" ");
        int price = 0;
        int plusCnt = 0;
        for (int i = 0; i<userArr.length; i++) {
            int sum = 0;
            for (int j = 1; j<arr.length; j++) {
                int tmp = Integer.parseInt(arr[j]); // 해당 이모티콘의 할인률
                if (tmp >= userArr[i][0]) {
                    //이모티콘의 할인률이 특정 유저의 구매 할인률 기준보다 높다면
                    sum += emoticonArr[j-1] - (emoticonArr[j-1] * tmp / 100);
                }
            }
            
            if (sum >= userArr[i][1]) {
                plusCnt++;
            } else {
                price += sum;
            }
        }
        if (plusCnt > maxCnt) {
            maxCnt = plusCnt;
            maxPrice = price;
            return;
        }
        if (plusCnt == maxCnt) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
    }
}