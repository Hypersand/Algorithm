import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Integer>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        lists = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == - 1) continue;
            lists[p].add(i);
        }
        int removeNode = Integer.parseInt(br.readLine());
        bfs(removeNode);

        int leafNode = 0;
        for (int i = 0; i < N; i++) {
            if (lists[i].contains(removeNode)) {
                if (lists[i].size() == 1) {
                    leafNode++;
                }
                continue;
            }
            if (lists[i].size() == 0) {
                leafNode++;
            }
        }

        System.out.println(leafNode);
    }

    private static void bfs(int removeNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(removeNode);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : lists[node]) {
                queue.add(next);
            }
            lists[node].clear();
            //삭제된 노드 표시
            lists[node].add(-1);
        }

    }
}
