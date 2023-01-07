
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static char [] str;
    private static List<bracket> bracketList = new ArrayList<>();
    private static Set<String> set = new TreeSet<>();
    private static boolean [] visited;
    private static boolean isFirst = true;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        str = br.readLine().toCharArray();
        visited = new boolean[str.length];
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                bracketList.add(new bracket(stack.pop(), i));
            }
            else {
                visited[i] = true;
            }
        }

        comb(0);
        for (String s : set) {
            System.out.println(s);
        }

    }

    private static void comb(int index) {
        if (index == bracketList.size()) {
            if (isFirst) isFirst = false;
            else {
                String ans = "";
                for (int i = 0; i < str.length; i++) {
                    if (visited[i]) {
                        ans += str[i];
                    }
                }
                set.add(ans);
            }
            return;
        }

        bracket brac = bracketList.get(index);
        visited[brac.start] = true;
        visited[brac.end] = true;
        comb(index + 1);
        visited[brac.start] = false;
        visited[brac.end] = false;
        comb(index + 1);
    }

    private static class bracket {
        int start;
        int end;

        public bracket(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


}
