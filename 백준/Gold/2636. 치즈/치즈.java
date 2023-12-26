import java.util.*;
import java.io.*;
 
 
public class Main {
    static int row, col, cheese = 0, depth = 0, result;
    static int arr[][];
    static boolean visit[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
 
        arr = new int[row][col];
 
        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) cheese++;
            }
        }
 
        while(cheese != 0){
            depth++;
            result = cheese;
            bfs();
        }
        System.out.println(depth);
        System.out.println(result);
 
    }
    static void bfs(){
        Queue<CheesePoint> q = new ArrayDeque<>();
 
        visit = new boolean[row][col];
        q.offer(new CheesePoint(0, 0));
        visit[0][0] = true;
        while(!q.isEmpty()){
            CheesePoint cp = q.poll();
            for(int i = 0; i < 4; i++){
                int X = cp.x + dx[i];
                int Y = cp.y + dy[i];
                if(!isRangeTrue(X, Y)) continue;
                if(visit[X][Y]) continue;
 
                //0이면 그대로 q에 넣어줌
                if(arr[X][Y] == 0){
                    q.offer(new CheesePoint(X, Y));
                    visit[X][Y] = true;
                }
                //1이면 0으로 바꿔준 뒤 치즈를 하나 없앰
                else if(arr[X][Y] == 1){
                    arr[X][Y] = 0;
                    cheese--;
                    visit[X][Y] = true;
                }
            }
        }
    }
    static boolean isRangeTrue(int x, int y){
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
 
class CheesePoint{
    int x, y;
 
    CheesePoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}