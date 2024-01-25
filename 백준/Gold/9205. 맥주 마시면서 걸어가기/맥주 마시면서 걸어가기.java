import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    private static List<Point> stores;
    private static Queue<Node> queue;
    private static Point endP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            queue = new LinkedList<>();
            stores = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            queue.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 20));
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                stores.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            st = new StringTokenizer(br.readLine());
            endP = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (bfs()) {
                sb.append("happy").append("\n");
            } else {
                sb.append("sad").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean bfs() {
        boolean[] visited = new boolean[stores.size()];
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int endDist = (Math.abs(node.x - endP.x) + Math.abs(node.y - endP.y));
            int endBeerCnt = endDist / 50;
            if (endDist % 50 > 0) endBeerCnt++;
            if (endBeerCnt <= node.beerCnt) {
                return true;
            }
            for (int i = 0; i < stores.size(); i++) {
                if (visited[i]) continue;
                int dist = Math.abs(node.x - stores.get(i).x) + Math.abs(node.y - stores.get(i).y);
                int requiredBeerCnt = dist / 50;
                if (dist % 50 > 0) {
                    requiredBeerCnt++;
                }
                if (node.beerCnt < requiredBeerCnt) continue;
                visited[i] = true;
                queue.add(new Node(stores.get(i).x, stores.get(i).y, 20));
            }
        }

        return false;
    }

    private static class Node {
        private int x;
        private int y;
        private int beerCnt;

        public Node(int x, int y, int beerCnt) {
            this.x = x;
            this.y = y;
            this.beerCnt = beerCnt;
        }
    }
}
