import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        int idx = 1;
        for (int i = 0; i < L; i++) {
            String num = br.readLine();
            map.put(num, idx++);
        }

        List<Node> list = new ArrayList<>();
        for (String i : map.keySet()) {
            list.add(new Node(i, map.get(i)));
        }

        Collections.sort(list);

        for (int i = 0; i < K; i++) {
            if (i >= list.size()) break;
            System.out.println(list.get(i).key);
        }

    }

    private static class Node implements Comparable<Node> {
        private String key;
        private int value;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Node n) {
            return this.value - n.value;
        }
    }
}
