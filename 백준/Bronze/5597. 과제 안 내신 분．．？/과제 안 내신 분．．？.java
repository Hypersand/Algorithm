import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] participants = new boolean[31];
        for (int i = 0; i< 28; i++) {
            int n = Integer.parseInt(br.readLine());
            participants[n] = true;
        }
        
        for (int i = 1; i<=30; i++) {
            if(!participants[i]) {
                System.out.println(i);
            }
        }
        
    }
}