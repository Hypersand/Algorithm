import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int timeTaken = Integer.parseInt(br.readLine()); //분 단위

        int curTime = hour * 60 + minute;
        curTime += timeTaken;
        int maxTime = 23 * 60 + 59; //23시 59분이 최대 maxTime
        if (curTime > maxTime) {
            curTime -= (maxTime + 1);
        }

        hour = curTime / 60;
        minute = curTime % 60;
        System.out.println(hour + " " + minute);
    }
}
