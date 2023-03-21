

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.contains("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if (s.contains("pop")) {
                if(stack.empty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.peek());
                    stack.pop();
                }
            }
            else if (s.contains("size")) {
                System.out.println(stack.size());
            }

            else if (s.contains("empty")) {
                if(stack.isEmpty()) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }
            else {
                if(stack.empty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.peek());
                }
            }
        }

    }
}
