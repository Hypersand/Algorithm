import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Integer>[] newLists;
    private static int[] sizeArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        sizeArr = new int[N + 1];
        visited[R] = true;
        List<Integer>[] lists = new List[N + 1];
        newLists = new List[N + 1];
        for (int i = 1; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
            newLists[i] = new ArrayList<>();
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            lists[U].add(V);
            lists[V].add(U);
            if (U == R) {
                queue.add(V);
                newLists[U].add(V);
                visited[V] = true;
            }
            if (V == R) {
                queue.add(U);
                newLists[V].add(U);
                visited[U] = true;
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0;  i < lists[node].size(); i++) {
                int tmp = lists[node].get(i);
                if (!visited[tmp]) {
                    visited[tmp] = true;
                    newLists[node].add(tmp);
                    queue.add(tmp);
                }
            }
        }

        countSubTreeNode(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int node = Integer.parseInt(br.readLine());
            sb.append(sizeArr[node]).append("\n");
        }

        System.out.println(sb);
    }

    private static void countSubTreeNode(int curNode) {
        sizeArr[curNode] = 1;
        for (int node : newLists[curNode]) {
            countSubTreeNode(node);
            sizeArr[curNode] += sizeArr[node];
        }
    }
}
