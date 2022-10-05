

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        for(int i = 0; i<N; i++) {
            map.put(br.readLine(),1);
        }
        for (int j = 0; j < M; j++) {
            String s = br.readLine();
            if (map.containsKey(s)) {
                map1.put(s, 1);
                count++;
            }
            }
        Object[] mapkey = map1.keySet().toArray();
        Arrays.sort(mapkey);
        System.out.println(count);
        for (int i = 0; i < map1.size(); i++) {
            System.out.println(mapkey[i]);
        }
        }
    }
