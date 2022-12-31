
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int [] arr;
    private static int [] tool;
    private static int min = Integer.MAX_VALUE;
    private static int max = -1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        tool = new int[4];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            tool[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void backTracking(int index) {
        if(index==N-1) {
            max = Math.max(max, arr[N-1]);
            min = Math.min(min, arr[N - 1]);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int tmp = 0;
            int a = arr[index + 1];
            if(tool[i]!=0) {
                if (i == 0) {
                    tmp = arr[index] + arr[index + 1];
                    tool[i]--;
                } else if (i == 1) {
                    tmp = arr[index] - arr[index + 1];
                    tool[i]--;
                } else if (i == 2) {
                    tmp = arr[index] * arr[index + 1];
                    tool[i]--;
                } else {
                    tmp = arr[index] / arr[index + 1];
                    tool[i]--;
                }
                arr[index+1] = tmp;
                backTracking(index+1);
                arr[index+1] = a;
                tool[i]++;
            }

        }
    }

}
