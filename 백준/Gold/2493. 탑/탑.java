
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Node> stack = new Stack<>();
        int [] arr = new int[N];
        int [] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<N; i++) {
            Node node = new Node(num[i],i+1);

            while(!stack.isEmpty()) {
                if(node.height<=stack.peek().height) {
                    arr[i] = stack.peek().idx;
                    break;
                }
                else {
                    stack.pop();
                }
            }
            if(stack.isEmpty()) {
                arr[i] = 0;
            }
            stack.push(node);
        }

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]+" ");
        }

        System.out.println(sb);
    }
}

class Node {
    int height;
    int idx;

    public Node(int height, int idx) {
        this.height = height;
        this.idx = idx;
    }
}
