import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = 0;
        for (int i = 0; i<musicinfos.length; i++) {
            String[] musicinfo = musicinfos[i].split(",");
            String start = musicinfo[0];
            String end = musicinfo[1];
            String title = musicinfo[2];
            String music = musicinfo[3];
            int playTime = parseTime(start, end);
            music = parseMusic(music);
            //라디오에서 재생된 악보
            String[] arr = new String[playTime];
            int idx = 0;
            int length = music.length();
            while (idx < playTime) {
                arr[idx] = String.valueOf(music.charAt(idx % length));
                idx++;
            }
            
            //기억하는 악보와 재생된 악보 비교
            if (validate(m, arr)) {
                if (playTime > max) {
                    max = playTime;
                    answer = title;
                }
            }
        }
        return answer;
    }
    
    private static boolean validate(String m, String[] arr) {
        m = parseMusic(m);
        int length = m.length();
        //기억한 멜로디의 길이가 라디오에서 재생된 음악의 길이보다 길면 무조건 틀림
        if (length > arr.length) return false;
        for (int i = 0; i<=arr.length - length; i++) {
            String str= "";
            for (int j = i; j<i+length; j++) {
                str += arr[j];
            }
            if (str.equals(m)) return true;
        }
        return false;
    }
    
    private static String parseMusic(String music) {
        return music.replace("C#", "c")
                    .replace("D#", "d")
                    .replace("F#", "f")
                    .replace("G#", "g")
                    .replace("A#", "a");
    }
    
    private static int parseTime(String start, String end) {
        String[] startArr = start.split(":");
        String[] endArr = end.split(":");
        
        int startTime = Integer.parseInt(startArr[0]) * 60 +
            Integer.parseInt(startArr[1]);
        int endTime = Integer.parseInt(endArr[0]) * 60 +
            Integer.parseInt(endArr[1]);
        
        return endTime - startTime;
    }
}