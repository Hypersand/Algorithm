import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractCollection;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String[] arr = br.readLine().split("");
        st = new StringTokenizer(br.readLine());
        int minA = Integer.parseInt(st.nextToken());
        int minC = Integer.parseInt(st.nextToken());
        int minG = Integer.parseInt(st.nextToken());
        int minT = Integer.parseInt(st.nextToken());

        int answer = 0;
        int aCnt = 0;
        int cCnt = 0;
        int gCnt = 0;
        int tCnt = 0;
        for (int i = 0; i < P; i++) {
            if (arr[i].equals("A")) {
                aCnt++;
            } else if (arr[i].equals("C")) {
                cCnt++;
            } else if (arr[i].equals("G")) {
                gCnt++;
            } else {
                tCnt++;
            }
        }

        if (aCnt >= minA && cCnt >= minC && gCnt >= minG && tCnt >= minT) {
            answer++;
        }

        for (int i = 0; i < S - P; i++) {
            if (arr[i].equals("A")) {
                aCnt--;
            } else if (arr[i].equals("C")) {
                cCnt--;
            } else if (arr[i].equals("G")) {
                gCnt--;
            } else {
                tCnt--;
            }
            if (arr[i + P].equals("A")) {
                aCnt++;
            } else if (arr[i + P].equals("C")) {
                cCnt++;
            } else if (arr[i + P].equals("G")) {
                gCnt++;
            } else {
                tCnt++;
            }
            
            if (aCnt >= minA && cCnt >= minC && gCnt >= minG && tCnt >= minT) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
