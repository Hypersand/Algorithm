import java.util.*;
class Solution {
    private static int[] parents;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parents = new int[n];
        
        for (int i = 0; i < n; i++)
            parents[i] = i;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        
        for (int i = 0; i < costs.length; i++) {
            if(find(costs[i][0]) != find(costs[i][1])) { 
                answer += costs[i][2];
                union(costs[i][0], costs[i][1]);
            }
        }
        return answer;
    }
    
    public int find(int node) {
        if (parents[node] == node)
            return node;
        return parents[node] = find(parents[node]);
    }
    public void union(int node1, int node2) {
        int p1 = find(node1);
        int p2 = find(node2);
        
        if (p1 < p2)
            parents[p2] = p1;
        else
            parents[p1] = p2;
    } 
}