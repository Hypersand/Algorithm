import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            String[] startStrs = plans[i][1].split(":");
            int start = Integer.parseInt(startStrs[0]) * 60 + Integer.parseInt(startStrs[1]);
            int playTime = Integer.parseInt(plans[i][2]);
            
            tasks.add(new Task(name, start, playTime));
        }
        
        Collections.sort(tasks);
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < tasks.size(); i++) {
            map.put(tasks.get(i).name, tasks.get(i).playTime);
        }
        
        Stack<Task> stack = new Stack<>();
        String curName = tasks.get(0).name;
        String[] result = new String[tasks.size()];
        int order = 0;
        
        for (int i = 0; i < tasks.size() - 1; i++) {
            Task preTask = tasks.get(i);
            Task postTask = tasks.get(i + 1);
            int remainTime = preTask.start + preTask.playTime - postTask.start;
            // 시간이 오바나는 경우 멈춰야 함.
            if (remainTime > 0) {
                preTask.playTime = remainTime;
                stack.push(preTask);
                continue;                
            }
            
            // 시간이 오바나지 않는다면?
            result[order++] = preTask.name;
            remainTime *= -1;
            while (remainTime > 0 && !stack.isEmpty()) {
                Task remainTask = stack.pop();
                if (remainTask.playTime <= remainTime) {
                    remainTime -= remainTask.playTime;
                    result[order++] = remainTask.name;
                } else {
                    remainTask.playTime -= remainTime;
                    stack.push(remainTask);
                    break;
                }
            }
        }
        
        stack.push(tasks.get(tasks.size() - 1));
        
        while (!stack.isEmpty()) {
            result[order++] = stack.pop().name;
        }
        
        
        return result;
    }
    
    private static class Task implements Comparable<Task> {
        private String name;
        private int start;
        private int playTime;
        
        public Task(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
        
        public int compareTo(Task task) {
            return this.start - task.start;
        }
    }
}