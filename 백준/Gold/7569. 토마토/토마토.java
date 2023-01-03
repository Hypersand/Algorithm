

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int H;
    private static int [][][]arr;
    private static int [][][]arr2;
    private static boolean [][][]visited;
    private static Queue<Node> queue = new LinkedList<>();
    private static int [] dr = {-1,1,0,0,0,0};
    private static int [] dc = {0,0,-1,1,0,0};
    private static int [] dh = {0,0,0,0,-1,1};
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][N][M];
        arr2 = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k]==1) {
                        queue.add(new Node(i, j, k));
                        visited[i][j][k] = true;
                    }
                }
            }
        }
        bfs();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(arr[i][j][k]==0&&!visited[i][j][k]) max = -1;
                }
            }
        }

        System.out.println(max);


    }

    private static void bfs() {
        while(!queue.isEmpty()) {
            Node a = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nh = a.height + dh[i];
                int nr = a.r + dr[i];
                int nc = a.c + dc[i];
                if (nh >= 0 && nr >= 0 && nc >= 0 && nh < H && nr < N && nc < M) {
                    if(!visited[nh][nr][nc]&&arr[nh][nr][nc]==0) {
                        visited[nh][nr][nc] = true;
                        queue.add(new Node(nh, nr, nc));
                        arr2[nh][nr][nc] = arr2[a.height][a.r][a.c] + 1;
                        max = Math.max(arr2[nh][nr][nc], max);
                    }
                }
            }
        }

    }
}

class Node {
    int height;
    int r;
    int c;

    public Node(int height, int r, int c) {
        this.height = height;
        this.r = r;
        this.c = c;
    }
}
