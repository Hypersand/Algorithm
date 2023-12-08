import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken(); // 개강총회 시작 시간
        String E = st.nextToken(); // 개강총회 종료 시간
        String Q = st.nextToken(); // 스트리밍 종료 시간
        int start = Integer.parseInt(S.substring(0, 2) + S.substring(3, 5));
        int end = Integer.parseInt(E.substring(0, 2) + E.substring(3, 5));
        int quit = Integer.parseInt(Q.substring(0, 2) + Q.substring(3, 5));
        String str;
        int cnt = 0;
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        while ((str = br.readLine()) != null) {
            String[] info = str.split(" ");
            int time = Integer.parseInt(info[0].substring(0, 2) + info[0].substring(3, 5));
            String name = info[1];
            //정상적인 입장시간일경우
            if (time <= start) {
                map.put(name, 1);
                continue;
            }
            //만약 key가 존재한다면 ? -> 이미 입장한 사람
            if (map.containsKey(name)) {
                //정상적인 퇴장인지 판단
                if (time >= end && time <= quit) {
                    if (!set.contains(name)) {
                        set.add(name);
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
