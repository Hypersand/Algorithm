import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                arr[i][j] = line[j].charAt(0);
            }
        }


        int startRow = 0;
        int endRow = R - 1;
        while (startRow <= endRow) {
            int midRow = (startRow + endRow) / 2;
            Set<String> set = new HashSet<>();
            boolean flag = true;
            for (int col = 0; col < C; col++) {
                StringBuilder sb = new StringBuilder();
                for (int row = midRow; row < R; row++) {
                    sb.append(arr[row][col]);
                }

                //포함하고 있으면 row를 줄여야 함.
                if (set.contains(sb.toString())) {
                    flag = false;
                    break;
                }
                set.add(sb.toString());
            }

            if (!flag) {
                endRow = midRow - 1;
            } else {
                startRow = midRow + 1;
            }
        }

        System.out.println(endRow);
    }
}
