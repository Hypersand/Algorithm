

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    private static boolean [][] visited;
    private static int [][] arr;
    private static int count;
    private static int []D1 = {-1,1,0,0};
    private static int []D2 = {0,0,-1,1};
    private static ArrayList<Integer> result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];
        result = new ArrayList<>();
        count = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            arr[i] = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] &&arr[i][j] == 1) {
                        count = 1;
                        dfs(i, j);
                        result.add(count);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(result);
        sb.append(result.size()+"\n");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)+"\n");
        }

        System.out.println(sb);
    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int now_x = x + D1[i];
            int now_y = y + D2[i];

            if(now_x>=0 && now_y>=0 && now_x < arr.length && now_y < arr.length) {
                if(arr[now_x][now_y] == 1 && !visited[now_x][now_y]) {
                    dfs(now_x, now_y);
                    count++;
                }
            }
        }
        return count;

    }

}
