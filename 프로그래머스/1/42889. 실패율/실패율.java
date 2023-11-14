import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Node> list = new ArrayList<>();
        
        for (int i = 0; i<stages.length; i++) {
            map.put(stages[i], map.getOrDefault(stages[i], 0 ) + 1); 
        }
        
        int cnt = stages.length;
        for (int i = 1; i<=N; i++) {
            if (map.containsKey(i)) {
                double fail = map.get(i) / (double)cnt;
                cnt -= map.get(i);
                list.add(new Node(i, fail));
                
            } else {
                list.add(new Node(i, 0));
            }
        }
        
        Collections.sort(list);
        int[] result = new int[N];
        for (int i = 0; i<list.size(); i++) {
            result[i] = list.get(i).stage;
        }
        
        return result;
    }
}

class Node implements Comparable<Node> {
    int stage;
    double fail;
    
    public Node (int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }
    
    @Override
    public int compareTo(Node node) {
        if (this.fail == node.fail) {
            return this.stage - node.stage;
        } else { 
            if (this.fail > node.fail) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}