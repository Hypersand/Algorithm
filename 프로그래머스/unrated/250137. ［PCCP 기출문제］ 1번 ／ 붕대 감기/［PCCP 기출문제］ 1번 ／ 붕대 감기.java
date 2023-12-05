import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxTime = 0;
        int maxHealth = health;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<attacks.length; i++) {
            map.put(attacks[i][0], attacks[i][1]);
            maxTime = Math.max(maxTime, attacks[i][0]);
        }
        //연속 회복 성공 카운트
        int cnt = 0;
        for (int i = 1; i<=maxTime; i++) {
            //1.몬스터가 공격한 시간일 경우
            if (map.containsKey(i)) {
                cnt = 0;
                health -= map.get(i);
                if (health <= 0) {
                    return -1;
                }
                continue;
            }
            //2.몬스터가 공격한 시간이 아닐 경우
            cnt++;
            //2-1.회복 시전시간을 채울 경우
            if (cnt == bandage[0]) {
                health += bandage[2] + bandage[1];
                cnt = 0;
                if (health >= maxHealth) {
                    health = maxHealth;
                }
                continue;
            }
            //2-2.회복 시전시간을 채우지 못한 경우
            health += bandage[1];
            if (health >= maxHealth) {
                health = maxHealth;
            }
        }
        return health;
    }
}