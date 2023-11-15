import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static int[] arr;
    private static boolean[] isRobot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[2 * N];
        isRobot = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        while (true) {
            cnt++;
            rotateBelt();
            rotateRobot();
            addRobot();

            int zeroCnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    zeroCnt++;
                }
            }

            if (zeroCnt >= K) {
                break;
            }
        }

        System.out.println(cnt);
    }

    private static void addRobot() {
        if (arr[0] > 0 && !isRobot[0])  {
            isRobot[0] = true;
            arr[0]--;
        }
    }

    private static void rotateRobot() {
        if (isRobot[N - 1]) {
            isRobot[N-1] = false;
        }

        for (int i = N-2; i >= 0; i--) {
            if (isRobot[i] && !isRobot[i+1] && arr[i+1] >= 1) {
                if (i + 1 == N - 1) {
                    isRobot[i] = false;
                    arr[i+1]--;

                } else {
                    isRobot[i] = false;
                    isRobot[i+1] = true;
                    arr[i+1]--;
                }
            }

        }
    }

    private static void rotateBelt() {
        int tmp = arr[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = tmp;

        for (int i = N - 1; i > 0; i--) {
            isRobot[i] = isRobot[i - 1];
        }
        isRobot[0] = false;
    }
}
