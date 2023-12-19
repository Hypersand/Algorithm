import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int book = Integer.parseInt(st.nextToken());
            if (book > 0) positive.add(book);
            else negative.add(book);
        }
        Collections.sort(negative);
        Collections.sort(positive, Collections.reverseOrder());

        List<Integer> distance = new ArrayList<>();
        while(!negative.isEmpty()) {
            int temp = negative.remove(0);
            for (int i=1; i<M; i++) {
                if (!negative.isEmpty()) {
                    negative.remove(0);
                }
            }
            distance.add(-temp);
        }

        while(!positive.isEmpty()) {
            int temp = positive.remove(0);
            for (int i=1; i<M; i++) {
                if (!positive.isEmpty()) {
                    positive.remove(0);
                }
            }
            distance.add(temp);
        }

        int result = 0;
        Collections.sort(distance);
        for (int i=0; i<distance.size() - 1; i++) {
            result += (distance.get(i)*2);
        }
        result += distance.get(distance.size()- 1);

        System.out.println(result);
    }
}
