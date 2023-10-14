

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            set.add(str);
        }

        int size = set.size();

        if (game.equals("Y")) {
            System.out.println(size / 1);
        } else if (game.equals("F")) {
            System.out.println(size / 2);
        } else {
            System.out.println(size / 3);
        }
    }
}
