import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            map.put(row, map.getOrDefault(row, 0) + 1);
        }

        int K = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();
        for (String row : map.keySet()) {
            list.add(new Node(row, map.get(row)));
        }

        Collections.sort(list);

        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            int zeroCnt = 0;
            for (int j = 0; j < node.row.length(); j++) {
                if (node.row.charAt(j) == '0') zeroCnt++;
            }

            if (K < zeroCnt) continue;
            if ((K - zeroCnt) % 2 == 1) continue;
            System.out.println(node.count);
            return;
        }

        System.out.println(answer);
    }

    private static class Node implements Comparable<Node>{
        private String row;
        private int count;

        public Node(String row, int count) {
            this.row = row;
            this.count = count;
        }

        @Override
        public int compareTo(Node node) {
            return node.count - this.count;
        }
    }
}
