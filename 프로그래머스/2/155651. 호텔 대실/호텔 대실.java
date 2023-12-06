import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        List<Book> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i<book_time.length; i++) {
            String[] startArr = book_time[i][0].split(":");
            String[] endArr = book_time[i][1].split(":");
            int start = Integer.parseInt(startArr[0]) * 60 + Integer.parseInt(startArr[1]);
            int end = Integer.parseInt(endArr[0]) * 60 + Integer.parseInt(endArr[1]);
            list.add(new Book(start, end));
        }
        Collections.sort(list);
        int answer = 0;
        for (int i = 0; i<list.size(); i++) {
            if (!pq.isEmpty() && pq.peek() + 10 <= list.get(i).start) {
                pq.poll();
                answer--;
            }
            answer++;
            pq.add(list.get(i).end);
        }
        
        return answer;
    }
    
    public static class Book implements Comparable<Book> {
        private int start;
        private int end;
        public Book(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Book b) {
            if (this.start == b.start) {
                return this.end - b.end;
            }
            return this.start - b.start;
        }
        
    }
}