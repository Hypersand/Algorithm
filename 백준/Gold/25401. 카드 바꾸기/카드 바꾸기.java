import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxSameCnt = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], map.getOrDefault(map.get(arr[i]), 0) + 1);
            maxSameCnt = Math.max(maxSameCnt, map.get(arr[i]));
        }
        int minSameCnt = N - maxSameCnt;

        // 1. 일정하게 변하는 상황 만들기
        int minChangeCnt = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            int[] arr2 = arr.clone();
            int dist = arr[i + 1] - arr[i];
            int cnt = 0;
            boolean flag = true;
            for (int j = i - 1; j >= 0; j--) {
                if (arr2[j + 1] - arr2[j] != dist) {
                    arr2[j] = arr2[j + 1] - dist;
                    cnt++;
                }
            }

            for (int j = i + 2; j < N; j++) {
                if (arr2[j] - arr2[j - 1] != dist) {
                    arr2[j] = arr2[j - 1] + dist;
                    cnt++;
                }
            }

            minChangeCnt = Math.min(minChangeCnt, cnt);
        }
        System.out.println(Math.min(minSameCnt, minChangeCnt));
    }
}
