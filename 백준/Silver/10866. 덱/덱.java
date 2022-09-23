
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Integer> deque = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push_front")) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            }
            if(s.equals("push_back")) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            if(s.equals("pop_front")) {
                if(deque.isEmpty()) {
                    sb.append(-1+"\n");
                }
                else {
                    sb.append(deque.pollFirst()).append("\n");
                }
            }
            if(s.equals("pop_back")) {
                if(deque.isEmpty()) {
                    sb.append(-1+"\n");
                }
                else {
                    sb.append(deque.pollLast()).append("\n");
                }
            }
            if(s.equals("size")) {
                sb.append(deque.size()).append("\n");
            }
            if(s.equals("empty")) {
                if(deque.isEmpty()) {
                    sb.append(1+"\n");
                }
                else {
                    sb.append(0+"\n");
                }
            }
            if(s.equals("front")) {
                if(deque.isEmpty()) {
                    sb.append(-1+"\n");
                }
                else {
                    sb.append(deque.peekFirst()).append("\n");
                }
            }
            if(s.equals("back")) {
                if(deque.isEmpty()) {
                    sb.append(-1+"\n");
                }
                else {
                    sb.append(deque.peekLast()).append("\n");
                }
            }
         }
        System.out.println(sb);
    }
}
