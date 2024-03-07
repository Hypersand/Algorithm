import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");
        int blueCnt = 0;
        int redCnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i].equals("R")) {
                redCnt++;
                continue;
            }

            blueCnt++;
        }

        if (blueCnt == 0 || redCnt == 0) {
            System.out.println(0);
            return;
        }

        int idx = 0;
        //왼쪽으로 빨간공 모으기
        for (int i = 0; i < N; i++) {
            if (arr[i].equals("B")) {
                idx = i;
                break;
            }
        }
        int cnt1 = 0;
        for (int i = N - 1; i > idx; i--) {
            if (arr[i].equals("R")) {
                cnt1++;
            }
        }


        //오른쪽으로 빨간공 모으기
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i].equals("B")) {
                idx = i;
                break;
            }
        }

        int cnt2 = 0;
        for (int i = 0; i < idx; i++) {
            if (arr[i].equals("R")) {
                cnt2++;
            }
        }


        //왼쪽으로 파란공 모으기
        for (int i = 0; i < N; i++) {
            if (arr[i].equals("R")) {
                idx = i;
                break;
            }
        }

        int cnt3 = 0;
        for (int i = N - 1; i > idx; i--) {
            if (arr[i].equals("B")) {
                cnt3++;
            }
        }


        //오른족으로 파란공 모으기
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i].equals("R")) {
                idx = i;
                break;
            }
        }

        int cnt4 = 0;
        for (int i = 0; i < idx; i++) {
            if (arr[i].equals("B")) {
                cnt4++;
            }
        }

        int answer = 0;
        answer = Math.min(Math.min(cnt1, cnt2), Math.min(cnt3, cnt4));
        System.out.println(answer);
    }
}
