import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> multiTab = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < K; i++) {
            int num = arr[i];
            if (multiTab.contains(num)) continue;
            if (multiTab.size() < N && !multiTab.contains(num)) {
                multiTab.add(num);
                continue;
            }
            //1. 멀티탭이 꽉찼고 멀티탭에 꽂힌 전자기기중 이후에 또 꽂을 일이 없을 때 -> 꽂을 일이 없는 애를 뽑는다.
            boolean allUsed = true;
            for (Integer tmp : multiTab) {
                boolean isUsed = false;
                for (int j = i + 1; j < K; j++) {
                    if (tmp == arr[j]) {
                        isUsed = true;
                        break;
                    }
                }

                if (!isUsed) {
                    allUsed = false;
                    multiTab.remove(tmp);
                    multiTab.add(num);
                    answer++;
                    break;
                }
            }

            //2. 멀티탭이 꽉찼고 멀티탭에 꽂힌 전자기기 모두 이후 또 꽂아야 될때 -> 가장 늦게 꽂는걸 뽑는다
            if (allUsed) {
                int max = 0;
                for (Integer tmp : multiTab) {
                    for (int j = i + 1; j < K; j++) {
                        if (tmp == arr[j]) {
                            max = Math.max(max, j);
                            break;
                        }
                    }
                }

                multiTab.remove(arr[max]);
                multiTab.add(num);
                answer++;
            }
        }

        System.out.println(answer);
    }

}
