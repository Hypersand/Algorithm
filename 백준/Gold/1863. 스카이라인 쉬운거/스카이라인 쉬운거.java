import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[50001];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = y;
        }

        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int i = 0; i < n; i++){
            while(!stack.empty() && stack.peek() > arr[i]){
                answer += 1;
                stack.pop();
            }

            if(!stack.empty() && stack.peek() == arr[i])
                continue;

            stack.push(arr[i]);
        }

        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (num == 0) {
                continue;
            }
            answer++;
        }

        System.out.println(answer);
    }
}
