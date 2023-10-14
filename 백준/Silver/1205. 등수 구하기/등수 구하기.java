import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int myGrade = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(1);
            return;
        }

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            list.add(tmp);
        }

        Collections.sort(list);
        int rank = 1;

        for (int i = list.size() - 1; i >= 0; i--) {
            if (rank > P || (list.get(0) >= myGrade && N == P)) {
                System.out.println(-1);
                return;
            }
            int tmp = list.get(i);

            if (tmp < myGrade) {
                break;
            }

            if (tmp > myGrade) {
                rank++;
            }
        }

        System.out.println(rank);
    }
}
