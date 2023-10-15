import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] arr = br.readLine().split("");
        boolean[] visited = new boolean[arr.length];

        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("P")) {
                boolean isEat = false;

                for (int j = i - K; j < i; j++) {
                    if (j >= 0 && arr[j].equals("H") && !visited[j]) {
                        cnt++;
                        visited[j] = true;
                        isEat = true;
                        break;
                    }
                }

                if (!isEat) {
                    for (int j = i; j < i + K + 1; j++) {
                        if (j < arr.length && arr[j].equals("H") && !visited[j]) {
                            cnt++;
                            visited[j] = true;
                            break;
                        }
                    }
                }

            }
        }

        System.out.println(cnt);
    }
}
