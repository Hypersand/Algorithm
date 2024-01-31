import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        int[] levels = new int[52];
        boolean[] visited = new boolean[52];
        Stack<String> stack = new Stack<>();
        int level = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(")")) {
                level--;
                int length = 0;
                while (!stack.peek().equals("(")) {
                    stack.pop();
                    length++;
                }
                // "(" 제거
                stack.pop();
                // "K" 추출
                int K = Integer.parseInt(stack.pop());
                if (visited[level + 1]) {
                    levels[level] += K * (levels[level + 1] + length);
                    levels[level + 1] = 0;
                    visited[level + 1] = false;
                } else {
                    levels[level] += K * length;
                }

                continue;
            }
            else if (arr[i].equals("(")) {
                visited[level] = true;
                level++;
            }
            stack.push(arr[i]);
        }

        while (!stack.isEmpty()) {
            stack.pop();
            levels[1]++;
        }

        System.out.println(levels[1]);

    }

}
