import java.util.*;
class Solution {
    private static int[] parents;
    public int solution(int n, int[][] costs) {
        parents = new int[n+1];
        Arrays.sort(costs, new Comparator<>() {
            @Override
            public int compare(int[] costs1, int[] costs2) {
                return costs1[2] - costs2[2];
            }
        });
        
        //각 노드들에 대해서 자기 자신을 부모로 설정
        for (int i = 0; i<costs.length; i++) {
            parents[costs[i][0]] = costs[i][0];
            parents[costs[i][1]] = costs[i][1];
        }
        
        int answer = 0;
        for (int i = 0; i<costs.length; i++) {
            int A = costs[i][0];
            int B = costs[i][1];
            int cost = costs[i][2];
            if (find(A) != find(B)) {
                union(A, B);
                answer += cost;
            }
        }
        
        return answer;
    }
    
    private static int find(int node) {
        int next = parents[node];
        if (node == next) return node;
        return parents[node] = find(next);
    }
    
    private static void union(int A, int B) {
        int parentsA = find(A);
        int parentsB = find(B);
        if (parentsA < parentsB) {
            parents[parentsB] = parentsA;
            return;
        } 
        parents[parentsA] = parentsB;
        return;
    }
}