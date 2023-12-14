import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        int maxPlayTime = 0;
        int minIdx = 1500;
        String answer = "(None)";
        for (int i = 0; i<musicinfos.length; i++) {
            String[] infos = musicinfos[i].split(",");
            String start = infos[0];
            String end = infos[1];
            String title = infos[2];
            String order = infos[3];
            order = order.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
            String[] orderArr = order.split("");
            
            //일단 재생된 길이를 구한다.
            int playTime = calculateTime(start, end);
            String[] arr = new String[playTime];
            String tmp = "";
            //재생시간만큼 재생된 악보 도출
            for (int j = 0; j<arr.length; j++) {
                arr[j] = orderArr[j%orderArr.length];
                tmp += arr[j];
            }
            System.out.println(tmp);
            //악보를 길이 m만큼 슬라이딩 윈도우해서 m이랑 똑같아지는지 판별
            //조건에 부합한다면?
            if (search(m, arr)) {
                if (maxPlayTime < playTime) {
                    maxPlayTime = playTime;
                    minIdx = i;
                    answer = title;
                }
            }
            
        }
        return answer;
    }
    
    private static boolean search(String m, String[] arr) {
        //m의 정확한 길이 판별
        m = m.replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("A#", "a");
        int length = m.length();
        
        String str = "";
        //초기값 세팅
        //기억하는 멜로디의 길이가 재생된 길이보다 길다면?
        if (length > arr.length) {
            return false;
        }
        //재생된 길이가 기억하는 멜로디보다 길다면
        else {
            for (int i = 0; i<length; i++) {
                str += arr[i];
            }
            
            // 슬라이딩 윈도우로 탐색
            if (arr.length == 1) {
                if (str.equals(m)) {
                    return true;
                }
            }
            for (int i = 0; i<arr.length - 1; i++) {
                //검증
                if (str.equals(m)) {
                    return true;
                }
                //start 증가, end 증가
                str += arr[(i + length) % arr.length];
                str = str.substring(1, str.length());
            }
        }
        return false;
    }
    
    private static int calculateTime(String start, String end) {
        String[] startArr = start.split(":"); //12, 00
        String[] endArr = end.split(":");  // 12, 14
        int startNum = 60 * Integer.parseInt(startArr[0]) + Integer.parseInt(startArr[1]);
        int endNum = 60 * Integer.parseInt(endArr[0]) + Integer.parseInt(endArr[1]);
        return endNum - startNum;
    }
    
}