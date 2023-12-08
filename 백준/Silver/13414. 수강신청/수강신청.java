import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < L; i++) {
            String num = br.readLine();
            map.put(num, idx++);
        }

        List<Student> list = new ArrayList<>();
        for (Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Student(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if (cnt < K) {
                sb.append(list.get(i).num).append("\n");
                cnt++;
            }

        }
        System.out.println(sb);
    }

    private static class Student implements Comparable<Student> {
        String num;
        int idx;

        public Student(String num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Student o) {
            return this.idx - o.idx;
        }
    }
}
