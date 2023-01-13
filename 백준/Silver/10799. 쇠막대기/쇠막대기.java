
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        String [] str = br.readLine().split("");
        int count = 0;
        int divideLine= 0;

        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("(")) {
                count+=1;
                divideLine+=1;
                stack.push(str[i]);
            }
            else {
                if (stack.peek().equals("(")) {
                    stack.push(")");
                    count-=1;
                    divideLine-=1;
                    count += divideLine;
                }
                else {
                    stack.push(")");
                    divideLine-=1;
                }
            }
        }

        System.out.println(count);

    }
}
