
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static long [] arr;
    private static long [] subtotalTree;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 수의 개수
        int M = Integer.parseInt(st.nextToken());  // 수의 변경이 일어나는 횟수
        int K = Integer.parseInt(st.nextToken());  // 구간의 합을 구하는 횟수

        arr = new long[N+1];
        subtotalTree = new long[4 * N];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        createTree(1, N,1);

        int a,b;
        long c;
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());
            if (a == 1) {
                edit(1, N,1,b,c - arr[b]);
                arr[b] = c;
            }
            else {
                sb.append(sum(1, N, b, (int)c, 1)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static long createTree(int start, int end, int node) {

        if (start == end) {
            return subtotalTree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return subtotalTree[node] = createTree(start, mid, node * 2) + createTree(mid + 1, end, node * 2 + 1);
    }

    private static void edit(int start, int end, int node, int index, long diff) {
        if (index < start || index > end) {
            return;
        }
        subtotalTree[node] += diff;
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        edit(start, mid, node * 2,index, diff);
        edit(mid + 1, end, node * 2 + 1,index, diff);
    }

    private static long sum(int start, int end, int left, long right, int node) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return subtotalTree[node];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, left, right, 2 * node) + sum(mid + 1, end, left, right, 2 * node + 1);
    }


}
