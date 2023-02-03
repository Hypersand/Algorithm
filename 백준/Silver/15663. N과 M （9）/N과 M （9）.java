
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {


    private static int M;
    private static int [] arr;
    private static int [] arr2;
    private static boolean [] visited;
//    private static Map<String, Integer> map = new HashMap<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        arr2 = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        backTracking(0);

        System.out.println(sb);
    }

    private static void backTracking(int length) {
        if (length == M) {
            String str = "";
            for (int i = 0; i < M; i++) {
                str += arr2[i] + " ";
            }
//            if (!map.containsKey(str)) {
//                map.put(str, 1);
                sb.append(str);
                sb.append("\n");
//            }
        }
        else {
            int last = -1;
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i] && last != arr[i]) {
                    visited[i] = true;
                    arr2[length] = arr[i];
                    last = arr[i];
                    backTracking(length + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
