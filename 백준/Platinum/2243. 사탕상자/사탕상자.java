
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] trees = new int[4000001];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        init(1, 1, 1000000);


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());

            if (A == 1) {
                long B = Long.parseLong(st.nextToken());
                int tmp = search(1, 1000000, B); // 맛
                System.out.println(tmp);
                update(1, 1, 1000000, tmp, -1);
            }
            else {
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                update(1, 1, 1000000, B, C);
            }
        }

    }

    public static int search(int start, int end, long n) {

        int left = start;
        int right = end;

        do {

            int mid = (left + right) / 2;
            long sum = sum(1, 1, 1000000, 1, mid);

            if (sum < n)
                left = mid + 1;
            else right = mid - 1;

        } while (left <= right);

        return left;
    }

    private static int init(int node, int start, int end) {
        if (start == end) {
            return trees[node] = 0;
        }

        int mid = (start + end) / 2;

        return trees[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
    }

    private static int sum(int node, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return 0;
        }
        else if (left <= start && right >= end) {
            return trees[node];
        }

        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);

    }

    private static void update(int node, int start, int end, int index, int diff) {
        if (index < start || index > end) {
            return;
        }
        trees[node] += diff;

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, index, diff);
        update(node * 2+1, mid + 1, end, index, diff);
    }
}
