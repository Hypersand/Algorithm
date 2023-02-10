
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Person> frame = new ArrayList<>();
        int count = Integer.parseInt(br.readLine());
        int[] people = new int[101];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (people[tmp] > 0) {
                people[tmp]++;
                for (int j = 0; j < N; j++) {
                    if (frame.get(j).num == tmp) {
                        frame.get(j).good++;
                        break;
                    }
                }
            }
            else {
                if (frame.size() == N) {
                    Collections.sort(frame, new Comparator<Person>() {
                        @Override
                        public int compare(Person o1, Person o2) {
                            if (o1.good == o2.good) {
                                return o1.order - o2.order;
                            }
                            return o1.good-o2.good;
                        }
                    });
                    people[frame.get(0).num] = 0;
                    frame.remove(0);
                }
                frame.add(new Person(tmp, 1, i));
                people[tmp]++;
            }
        }

        for (int i = 1; i <= 100; i++) {
            if (people[i] != 0) {
                System.out.print(i+" ");
            }
        }
    }


    private static class Person {
        int num;
        int good;

        int order;

        public Person(int num, int good, int order) {
            this.num = num;
            this.good = good;
            this.order = order;
        }
    }
}
