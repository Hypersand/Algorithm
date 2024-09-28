import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Node root = new Node(Integer.parseInt(str));
        while (true) {
            str = br.readLine();
            if (str == null) break;
            if (str.isEmpty()) break;
            root.insert(Integer.parseInt(str));
        }

        postOrderSearch(root);
    }

    private static void postOrderSearch(Node node) {
        if (node == null) return;

        postOrderSearch(node.left);
        postOrderSearch(node.right);
        System.out.println(node.idx);
    }

    private static class Node {
        private int idx;
        private Node left;
        private Node right;

        public Node(int idx) {
            this.idx = idx;
        }

        public Node(int idx, Node left, Node right) {
            this.idx = idx;
            this.left = left;
            this.right = right;
        }

        public void insert(int childIdx) {
            if (childIdx < idx) {
                if (left == null) {
                    left = new Node(childIdx);
                } else {
                    left.insert(childIdx);
                }
            } else {
                if (right == null) {
                    right = new Node(childIdx);
                } else {
                    right.insert(childIdx);
                }
            }
        }
    }
}
