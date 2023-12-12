import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] isEven = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < isEven.length; i++) {
            int num = Integer.parseInt(st.nextToken());
            isEven[i] = (num % 2 == 0);
        }
        int start = 0;
        int end = 0;
        int cnt = 0;
        int maxLength = 0;
        while (end < N) {
            //1. end 숫자가 짝수일 경우
            if (isEven[end]) {
                maxLength = Math.max(maxLength, end - start - cnt + 1);
                end++;
            }
            //2. end 숫자가 홀수일 경우
            else {
                //1. 아직 홀수를 삭제할 카운트가 남아 있다면
                if (cnt < K) {
                    cnt++;
                    end++;
                }
                //2. 홀수를 삭제할 카운트가 없다면
                else {
                    //start가 홀수라면 cnt 차감
                    if (!isEven[start]) {
                        cnt--;
                    }
                    start++;
                }
            }
        }

        System.out.println(maxLength);
    }
}
