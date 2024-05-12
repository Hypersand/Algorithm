import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n;
    private static List<Node>[] lists;
    private static int farthestNodeNum = 0;
    private static int[] dists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        lists = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            lists[node1].add(new Node(node2, dist));
            lists[node2].add(new Node(node1, dist));
        }

        // 1. 루트 노드로부터 가장 먼 노드를 찾는다.
        findFarthestNode(1);

        // 2. 찾은 노드로부터 또 가장 먼 노드를 찾으면 트리의 지름
        findFarthestNode(farthestNodeNum);
        System.out.println(dists[farthestNodeNum] - 1);
    }

    private static void findFarthestNode(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        dists = new int[n + 1];
        dists[num] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Node next : lists[cur]) {
                if (dists[next.idx] != 0) continue;
                dists[next.idx] = dists[cur] + next.dist;
                queue.add(next.idx);
            }
        }

        int dist = 0;
        for (int i = 1; i <= n; i++) {
            if (dists[i] > dist) {
                dist = dists[i];
                farthestNodeNum = i;
            }
        }
    }

    private static class Node {
        private int idx;
        private int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}
