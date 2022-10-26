

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Map<String,Integer> map = new HashMap();
            int N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String b = st.nextToken();
                if(map.containsKey(b)) {
                    map.put(b, map.get(b) + 1);
                }
                else {
                    map.put(b, 1);
                }
            }
            int result = 1;

            for (int k : map.values()) {
                result *= (k+1);
            }

            System.out.println(result-1);
        }



    }
}
