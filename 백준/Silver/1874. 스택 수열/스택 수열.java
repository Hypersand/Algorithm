

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int k = 0;
        int max = 0;
        for(int i = 0; i<n; i++) {
            stack1.push(Integer.parseInt(br.readLine()));
        }
        if(n==1) {
            max = stack1.peek();
        }
        else {
            max = n;
        }

        for(int i = 1; i<=max; i++) {
            stack.push(i);
            sb.append("+");
            sb.append("\n");
            while((stack.peek().equals(stack1.elementAt(k)))) {
                stack.pop();
                sb.append("-");
                sb.append("\n");
                if(stack1.size()>1)
                    k++;
                if(stack.isEmpty()){
                    break;
                }
            }
        }
        if(!stack.isEmpty()&&stack1.size()!=1) {
            sb.setLength(0);
            sb.append("NO");
            System.out.println(sb);
        }
        else {
            System.out.println(sb);
        }
    }
}
