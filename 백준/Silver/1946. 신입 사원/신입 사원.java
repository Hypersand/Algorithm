
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            List<rank> list = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int document_rank = Integer.parseInt(st.nextToken());
                int interview_rank = Integer.parseInt(st.nextToken());
                list.add(new rank(document_rank, interview_rank));
            }

            Collections.sort(list, new Comparator<rank>() {
                @Override
                public int compare(rank o1, rank o2) {
                    return o1.document - o2.document;
                }
            });

            int minRank = list.get(0).interview;
            int fall = 0;

            for (int j = 1; j < N; j++) {
                if (list.get(j).interview > minRank) {
                    fall++;
                    continue;
                }

                minRank = list.get(j).interview;
            }

            System.out.println(N - fall);
        }

    }

    public static class rank {
        int document;
        int interview;

        public rank(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }
    }
}
