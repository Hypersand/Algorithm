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

        List<Word> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() >= M) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        for (String str : map.keySet()) {
            list.add(new Word(str, map.get(str), str.length()));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (Word word : list) {
            sb.append(word.word).append("\n");
        }
        System.out.println(sb);
    }

    public static class Word implements Comparable<Word> {
        private String word;
        private int cnt;
        private int length;

        public Word(String word, int cnt, int length) {
            this.word = word;
            this.cnt = cnt;
            this.length = length;
        }

        @Override
        public int compareTo(Word w) {
            if (this.cnt == w.cnt) {
                if (w.length == this.length) {
                    return this.word.compareTo(w.word);
                }

                return w.length - this.length;
            }
            return w.cnt - this.cnt;
        }
    }
}


