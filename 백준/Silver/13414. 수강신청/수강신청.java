import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>(); //학번, 순서
        for (int i = 0; i < L; i++) {
            String str = br.readLine();
            map.put(str, i);
        }

        List<Node> list = new ArrayList<>();
        for (Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Node(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        if (K > list.size()) {
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).num).append("\n");
            }
        } else {
            for (int i = 0; i < K; i++) {
                sb.append(list.get(i).num).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static class Node implements Comparable<Node> {
        String num;
        int idx;

        public Node(String num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return this.idx - o.idx;
        }
    }
}
