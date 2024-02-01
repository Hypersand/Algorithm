import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            List<Point> stores = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                stores.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            st = new StringTokenizer(br.readLine());
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (canArrived(start, end, stores)) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    private static boolean canArrived(Point start, Point end, List<Point> stores) {
        Queue<Point> queue = new LinkedList<>();
        boolean[] visited = new boolean[stores.size()];
        queue.add(start);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if ((double)(Math.abs(end.x - p.x) + Math.abs(end.y - p.y)) / 50 <= 20) {
                return true;
            }
            for (int i = 0; i<stores.size(); i++) {
                Point store = stores.get(i);
                if (visited[i]) continue;
                if ((double)(Math.abs(store.x - p.x) + Math.abs(store.y - p.y)) / 50 <= 20) {
                    visited[i] = true;
                    queue.add(store);
                }
            }
        }
        return false;
    }
}
