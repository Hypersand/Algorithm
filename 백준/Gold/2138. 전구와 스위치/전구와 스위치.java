import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] now = br.readLine().split("");
        String[] now2 = Arrays.copyOf(now, now.length);
        String[] result = br.readLine().split("");
        //1. 1번 스위치를 안눌렀을때
        int ans1 = 0;
        for (int i = 1; i < N; i++) {
            if (!now[i - 1].equals(result[i - 1])) {
                //스위치 온
                ans1++;
                for (int j = i - 1; j < i + 2; j++) {
                    if (now[j].equals("0")) {
                        now[j] = "1";
                    } else {
                        now[j] = "0";
                    }

                    if (j == N - 1) break;
                }
            }
        }

        //2. 1번 스위치를 눌렀을때
        int ans2 = 1;
        //1번 스위치온
        for (int i = 0; i < 2; i++) {
            if (now2[i].equals("0")) {
                now2[i] = "1";
            } else {
                now2[i] = "0";
            }
        }
        for (int i = 1; i < N; i++) {
            if (!now2[i - 1].equals(result[i - 1])) {
                //스위치 온
                ans2++;
                for (int j = i - 1; j < i + 2; j++) {
                    if (now2[j].equals("0")) {
                        now2[j] = "1";
                    } else {
                        now2[j] = "0";
                    }

                    if (j == N - 1) break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (!now[i].equals(result[i])) {
                ans1 = Integer.MAX_VALUE;
            }
            if (!now2[i].equals(result[i])) {
                ans2 = Integer.MAX_VALUE;
            }
        }

        if (ans1 == Integer.MAX_VALUE && ans2 == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(ans1, ans2));
        }
    }
}
