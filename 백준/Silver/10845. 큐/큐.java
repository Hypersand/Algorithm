

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i<=N; i++) {
            String s = br.readLine();
            if(s.contains("push")) {
                st = new StringTokenizer(s);
                st.nextToken();
                q.add(Integer.parseInt(st.nextToken()));
            }
            if(s.equals("pop")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(q.poll());
                }
            }
            if(s.equals("size")) {
                System.out.println(q.size());
            }
            if(s.equals("empty")) {
                if(q.isEmpty()) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }
            if(s.equals("front")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(q.peek());
                }
            }
            if(s.equals("back")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    for(int j = 0; j<q.size(); j++) {
                        if(j==q.size()-1) {
                            System.out.println(q.peek());
                        }
                        q.add(q.poll());
                    }
                }
            }
        }

    }
}
