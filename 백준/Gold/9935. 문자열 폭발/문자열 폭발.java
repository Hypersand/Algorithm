import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] strArr = br.readLine().toCharArray();
        String bombStr = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < strArr.length; i++) {
            stack.push(strArr[i]);

            if (stack.size() < bombStr.length()) continue;

            while (stack.size() >= bombStr.length()) {
                boolean flag = true;
                int idx = 0;
                for (int j = stack.size() - bombStr.length(); j < stack.size(); j++) {
                    if (stack.get(j) != bombStr.charAt(idx)) {
                        flag = false;
                        break;
                    }
                    idx++;
                }
                if (flag) {
                    for (int j = 0; j < bombStr.length(); j++) {
                        stack.pop();
                    }
                    continue;
                }
                break;
            }
        }

        StringBuilder answerSb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            answerSb.append(stack.get(i));
        }

        if (answerSb.toString().length() == 0) {
            System.out.println("FRULA");
            return;
        }

        System.out.println(answerSb);
    }
}
