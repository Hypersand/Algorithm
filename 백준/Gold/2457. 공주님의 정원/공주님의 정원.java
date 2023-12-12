
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Flower> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int startMonth = Integer.valueOf(st.nextToken());
            int startDay = Integer.valueOf(st.nextToken());
            int endMonth = Integer.valueOf(st.nextToken());
            int endDay = Integer.valueOf(st.nextToken());
            int start = startMonth * 100 + startDay;
            int end = endMonth * 100 + endDay;
            list.add(new Flower(start, end));
        }
        Collections.sort(list);
        int endDay = 1201;
        int currentEnd = 301; //현재 가장 늦게 끝나는 날짜
        int count = 0;
        int max = 0; //갱신되는 늦게 끝나는 날짜
        int idx = 0;

        while (currentEnd < endDay) {
            boolean isFound = false;
            for (int i = idx; i < list.size(); i++) {
                if (list.get(i).start > currentEnd) break;
                if (max < list.get(i).end) {
                    isFound = true;
                    max = list.get(i).end;
                    idx = i + 1;
                }
            }
            if (!isFound) {
                break;
            }
            currentEnd = max;
            count++;
        }

        if (currentEnd < endDay) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }

    }


    private static class Flower implements Comparable<Flower> {
        private int start;
        private int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower f) {
            if (this.start < f.start) {
                return -1;
            } else if (this.start == f.start) {
                if (this.end > f.end) {
                    return -1;
                } else if (this.end == f.end) {
                    return 0;
                }
                return 1;
            } else {
                return 1;
            }
        }
    }
}

