import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] arr = new int[timetable.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i<timetable.length; i++) {
            String[] times = timetable[i].split(":");
            int hour = Integer.parseInt(times[0])*100;
            int minute = Integer.parseInt(times[1]);
            arr[i] = hour + minute; 
            pq.add(arr[i]);
        }
        
        //n번의 셔틀 기회
        int shuttle = 900; //첫셔틀은 9시로 고정
        int max = 0;
        for (int i = 0; i<n; i++) {
            int cnt = 0;
            List<Integer> list = new ArrayList<>();
            //가장 일찍 기다린사람부터 셔틀 정원만큼 태우기
            while (!pq.isEmpty() && pq.peek() <= shuttle) {
                //셔틀 정원 다차면 빼기
                if (cnt == m) break;
                list.add(pq.poll());
                cnt++;
            }
            
            if (i == n - 1) {
                //셔틀 정원에 여유가 있다? -> 해당 셔틀을 탈 수 있는 가장 늦은 시각 = 셔틀 도착 시각
                if (cnt < m) {
                    max = shuttle;
                } 
                //셔틀 정원이 꽉찼다 -> 셔틀을 탄 애들을 포함해서 m번째로 탈 수 있는 시각을 구해야 된다.
                else {
                    //셔틀 정원이 1명인데 꽉참 -> 해당 크루보다 무조건 빨리 타야됨
                    //빨리 타지만 제일 늦게 탈 수 있는 시간 = 해당 크루보다 1분 빨리 타기
                    if (m == 1) {
                        max = timeParsing(list.get(0), - 1);

                    } 
                    //셔틀 정원이 2명 이상인데 꽉참
                    else {
                        int last = list.get(m - 1);
                        int lastSecond = list.get(m - 2);
                        max = timeParsing(last, -1);
                        pq.add(last);
                    }
                }
            }
            shuttle = timeParsing(shuttle, t);
        }
        if (max <= 0) return "00:00";
        String hour = "";
        String minute = "";
        hour = String.valueOf(max / 100);
        minute = String.valueOf(max % 100);
        if (hour.length() == 1) hour = "0" + hour;
        if (minute.length() == 1) minute = "0" + minute;
        
        return hour + ":" + minute;
        
    }
    
    private static int timeParsing(int shuttle, int t) {
        int minute = shuttle % 100;  
        int hour = shuttle / 100; 
        if (t > 0) {
            minute += t; 
            hour += minute / 60;
        } else {
            if (t == -60) {
                return (hour - 1) * 100 + minute;
            }
            minute += t;
            if (minute < 0) {
                minute += 60;
                hour -= 1;
            }
        }
        return (hour * 100) + (minute % 60);
    }
}