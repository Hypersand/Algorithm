import java.io.*;

public class Main {
    
    public static String[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(bf.readLine());
        arr = new String[N][N];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = " ";
            }
        }
        
        star(0, 0, N);
        
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void star(int x, int y, int N) {
        if (N == 1) {
            arr[x][y] = "*";
            return; 
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    star(x + i * (N / 3), y + j * (N / 3), N / 3);
                }
            }
        }
    }
}