
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        meeting[] arr = new meeting[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new meeting(a, b);
        }

        Arrays.sort(arr, new Comparator<meeting>() {
            @Override
            public int compare(meeting o1, meeting o2) {
                if (o1.end == o2.end) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });

        int count = 0;
        int tmp = 0;

        for (meeting meeting : arr) {
            if (tmp <= meeting.start) {
                tmp = meeting.end;
                count++;
            }
        }
        System.out.println(count);
    }

    private static class meeting {
        int start;
        int end;

        public meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
