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
        List<Line> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Line(start, end));
        }
        Collections.sort(list);
        int start = list.get(0).start;
        int end = list.get(0).end;
        int length = end - start;
        if (N == 1) {
            System.out.println(length);
            return;
        }
        for (int i = 1; i < N; i++) {
            //1. 시작점이 선분에 포함
            if (list.get(i).start >= start && list.get(i).start <= end) {
                //끝점이 바깥에 있을 경우에만 증가
                if (list.get(i).end > end) {
                    length += list.get(i).end - end;
                    end = list.get(i).end;
                }
                continue;
            }
            //2. 시작점이 선분 바깥
            length += list.get(i).end - list.get(i).start;
            start = list.get(i).start;
            end = list.get(i).end;
        }

        System.out.println(length);
    }

    public static class Line implements Comparable<Line> {
        private int start;
        private int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Line o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}
