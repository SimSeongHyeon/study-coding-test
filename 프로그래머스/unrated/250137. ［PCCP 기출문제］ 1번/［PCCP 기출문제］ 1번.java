class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int max_health = health;
        int timer = 0;
        int cnt_bandage = 0;
        int idx_attacks = 0;
        
        while (timer <= attacks[attacks.length - 1][0]) {            
            if (timer == attacks[idx_attacks][0]) {
                health -= attacks[idx_attacks][1];
                cnt_bandage = 0;
                idx_attacks++;
            } else if (health < max_health) {
                health += bandage[1];
                health = Math.min(health, max_health);
                cnt_bandage++;
            }
            
            if (health < 1) {
                answer = -1;
                break;
            }
            
            if (cnt_bandage == bandage[0]) {
                health += bandage[2];
                health = Math.min(health, max_health);
                cnt_bandage = 0;
            }
            
            timer++;
            
            answer = health;
        }
        
        return answer;
    }
}