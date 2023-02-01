
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[27][2];
        char value;
        char leftNode;
        char rightNode;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            value = st.nextToken().charAt(0);
            leftNode = st.nextToken().charAt(0);
            rightNode = st.nextToken().charAt(0);

            if (leftNode != '.') {
                arr[value - 'A'+1][0] = leftNode - 'A'+1;

            }
            if (rightNode != '.') {
                arr[value - 'A'+1][1] = rightNode - 'A'+1;
            }
        }

        preOrder(1);
        sb.append("\n");
        inOrder(1);
        sb.append("\n");
        postOrder(1);

        System.out.println(sb);
    }

    private static void preOrder(int node) {
        if (node == 0) {
            return;
        }
        sb.append((char) (node + 'A' - 1));
        preOrder(arr[node][0]);
        preOrder(arr[node][1]);

    }

    private static void inOrder(int node) {
        if (node == 0) {
            return;
        }
        inOrder(arr[node][0]);
        sb.append((char) (node + 'A' - 1));
        inOrder(arr[node][1]);

    }

    private static void postOrder(int node) {
        if (node == 0) {
            return;
        }
        postOrder(arr[node][0]);
        postOrder(arr[node][1]);
        sb.append((char) (node + 'A' - 1));
    }
}