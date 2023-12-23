import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        int cnt = 0;
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        while (idx < N) {
            //스택의 마지막 값보다 넣으려는 값이 크다면 스택의 k가 남는만큼 빼준다.
            while (!stack.isEmpty() && stack.peek() < arr[idx] && cnt < K) {
                stack.pop();
                cnt++;
            }
            stack.push(arr[idx++]);
        }

        while (stack.size() > N - K) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse());
    }
}
