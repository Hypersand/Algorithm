
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int [] counting = new int [21];
        int a = 0;
        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.equals("add")) {
                a = Integer.parseInt(st.nextToken());
                 if(counting[a]==0) {
                     counting[a]++;
                 }
            }
            else if(s.equals("remove")) {
                a = Integer.parseInt(st.nextToken());
                if(counting[a]>0) {
                    counting[a]--;
                }
            }

            else if(s.equals("check")) {
                a = Integer.parseInt(st.nextToken());
                if(counting[a]>0) {
                   sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }
            else if (s.equals("toggle")) {
                a = Integer.parseInt(st.nextToken());
                if(counting[a]>0) {
                    counting[a]--;
                }
                else {
                    counting[a]++;
                }
            }
            else if(s.equals("all")) {
                for(int j = 1; j<21; j++) {
                   counting[j]=1;
                }
            }
            else if (s.equals("empty")) {
                for(int j = 1; j<21; j++) {
                    counting[j]=0;
                }
            }
        }
        System.out.println(sb);

    }
}
