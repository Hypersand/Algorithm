
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        int answer = 0;
        int count1 = 0;
        int count2 = 0;
        String tmp = "";

        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("(")) {
                count1++;
            }
            else if (str[i].equals(")")) {
                if (tmp.equals("[")) {
                    System.out.println(0);
                    return;
                }
                count1--;
            }
            else if (str[i].equals("[")) {
                count2++;
            }
            else {
                if (tmp.equals("(")) {
                    System.out.println(0);
                    return;
                }
               count2--;
            }
            if (count1 < 0 || count2 < 0) {
                System.out.println(0);
                return;
            }
            tmp = str[i];
        }
        if (count1 != 0 || count2 != 0) {
            System.out.println(0);
            return;
        }


        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("(")) {
                stack.push("(");
            }
            else if (str[i].equals(")")) {
                if (stack.peek().equals("(")) {
                    stack.pop();
                    stack.push("2");
                }
                else {
                    int sum = 0;
                    while (!stack.peek().equals("(")) {
                        sum += Integer.parseInt(stack.pop());
                    }
                    sum *= 2;
                    stack.pop();
                    stack.push(String.valueOf(sum));
                }

            }
            else if (str[i].equals("[")) {
                stack.push("[");

            }
            else {
                if (stack.peek().equals("[")) {
                    stack.pop();
                    stack.push("3");
                }
                else {
                    int sum = 0;
                    while (!stack.peek().equals("[")) {
                        sum += Integer.parseInt(stack.pop());
                    }
                    sum *= 3;
                    stack.pop();
                    stack.push(String.valueOf(sum));
                }
            }
        }

        while (!stack.isEmpty()) {
            answer += Integer.parseInt(stack.pop());
        }

        System.out.println(answer);
    }
}
