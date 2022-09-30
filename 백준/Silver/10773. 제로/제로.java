

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i = 0; i<K; i++) {
            stack.push(Integer.parseInt(br.readLine()));
            if(stack.peek()==0) {
                stack.pop();
                stack.pop();
            }
        }
        for (int j = 0; j<stack.size(); j++) {
            sum += stack.get(j);
        }
        System.out.println(sum);

    }
}
