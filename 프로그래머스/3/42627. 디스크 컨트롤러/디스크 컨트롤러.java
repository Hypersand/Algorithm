import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        List<Job> list = new ArrayList<>();
        
        for (int i = 0; i<jobs.length; i++) {
            list.add(new Job(jobs[i][0], jobs[i][1]));
        }
        
        Collections.sort(list);
        PriorityQueue<Job> pq = new PriorityQueue<>((j1, j2) -> (j1.cost - j2.cost));
        
        int count = 0;
        int time = 0;
        int sum = 0;
        int idx = 0;
        
        while (count < list.size()) {
            while (idx < list.size() && list.get(idx).start <= time) {
                pq.add(list.get(idx));
                idx++;
            }
            
            //수행할 수 있는 작업이 없다면
            if (pq.isEmpty()) {
                time = list.get(idx).start;
            } else {
                Job job = pq.poll();
                sum += job.cost + time - job.start;
                time += job.cost;
                count++;
            }
            
            
        }
        
        return sum / list.size();
    }
    
    private static class Job implements Comparable<Job> {
        private int start;
        private int cost;
        
        public Job(int start, int cost) {
            this.start = start;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Job job) {
            if (this.start == job.start) {
                return this.cost - job.cost;
            }
            return this.start - job.start;
        }
    }
}