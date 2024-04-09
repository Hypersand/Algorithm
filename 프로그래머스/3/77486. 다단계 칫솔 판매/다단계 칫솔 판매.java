import java.util.*;

class Solution {
    private static List<Integer>[] lists;
    private static int[] benefits;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        lists = new ArrayList[enroll.length];
        benefits = new int[enroll.length];
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i<enroll.length; i++) {
            map.put(enroll[i], i);
            lists[i] = new ArrayList<>();
        }
        
        for (int i = 0; i<referral.length; i++) {
            if (referral[i].equals("-")) continue;
            lists[i].add(map.get(referral[i]));
        }
        
        for (int i = 0; i<seller.length; i++) {
            int start = map.get(seller[i]);
            int cost = amount[i] * 100;
            bfs(start, cost);
        }
        
        return benefits;
    }
    
    private static void bfs(int start, int cost) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if (cost * 0.1 < 1) {
                benefits[cur] += cost;
                break;
            } else {
                int tmpCost = cost;
                cost /= 10;
                benefits[cur] += tmpCost - cost;
            }
            
            if (lists[cur].size() == 0) break;
            queue.add(lists[cur].get(0));
        }
        
    }
}