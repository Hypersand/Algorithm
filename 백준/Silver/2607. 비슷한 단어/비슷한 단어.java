

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int answer = 0;

        for (int i = 1; i < arr.length; i++) {
            String tmp = arr[i];
            boolean[] visited = new boolean[arr[0].length()];
            int cnt = 0;
            for (int j = 0; j < tmp.length(); j++) {
                for (int k = 0; k < arr[0].length(); k++) {
                    if (arr[0].charAt(k) == tmp.charAt(j) && !visited[k]) {
                        visited[k] = true;
                        cnt++;
                        break;
                    }
                }
            }

            if (cnt == arr[0].length() - 1 && arr[0].length() - tmp.length() >= 0 && arr[0].length() - tmp.length() <= 1) {
                answer++;
                continue;
            }

            if (cnt == arr[0].length() && tmp.length() - arr[0].length() <= 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
