import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static int[] arr;
    private static List<Integer>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        lists = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        String str = "";
        while (!(str = br.readLine()).equals("-1 -1")) {
            String[] nums = str.split(" ");
            int num1 = Integer.parseInt(nums[0]);
            int num2 = Integer.parseInt(nums[1]);
            lists[num1].add(num2);
            lists[num2].add(num1);
        }

        int minScore = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            arr = new int[N+1];
            arr[i] = -1;
            bfs(i, 1);
            int score = 0;
            for (int j = 1; j < arr.length; j++) {
                if (i==j) continue;
                score = Math.max(score, arr[j]);
            }
            if (score < minScore) {
                minScore = score;
                queue.clear();
                queue.add(i);
                continue;
            }
            if (score == minScore) {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minScore).append(" ").append(queue.size()).append("\n");
        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");
        }

        System.out.println(sb);
    }

    private static void bfs(int idx, int depth) {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < lists[idx].size(); i++) {
            arr[lists[idx].get(i)] = 1;
            queue.add(new Node(lists[idx].get(i), 1));
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < lists[node.idx].size(); i++) {
                int num = lists[node.idx].get(i);
                if (arr[num] == 0) {
                    arr[num] = node.length + 1;
                    queue.add(new Node(num, node.length + 1));
                }
            }
        }
    }

    private static class Node {
        int idx;
        int length;
        public Node(int idx, int length) {
            this.idx = idx;
            this.length = length;
        }
    }


}
